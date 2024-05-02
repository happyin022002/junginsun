/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchTrs3PtyIFSvcOrdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.09
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2015.11.09 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong Ock, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderPreviewDBDAOSearchTrs3PtyIFSvcOrdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrs3PtyIFSvcOrd
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchTrs3PtyIFSvcOrdUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchTrs3PtyIFSvcOrdUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append("SET " ).append("\n"); 
		query.append("    LGS_COST_CD = NVL( (" ).append("\n"); 
		query.append("        SELECT LGS_COST.LGS_COST_CD" ).append("\n"); 
		query.append("        FROM TRS_LGS_COST_CD_CONV_RULE B ," ).append("\n"); 
		query.append("          TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("        WHERE A.COST_ACT_GRP_CD = B.COST_ACT_GRP_CD" ).append("\n"); 
		query.append("          AND B.LGS_COST_CD_CHK_FLG = DECODE(SUBSTR(A.FM_NOD_CD, 1, 5) , SUBSTR(A.TO_NOD_CD, 1, 5) , 'Y', 'N')" ).append("\n"); 
		query.append("          AND LGS_COST.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("          AND A.CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("          AND A.TRSP_SO_TP_CD = 'Y'" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT LGS_COST.LGS_COST_CD" ).append("\n"); 
		query.append("        FROM TES_LGS_COST LGS_COST" ).append("\n"); 
		query.append("        WHERE LGS_COST.LGS_COST_CD = 'TR' || DECODE(A.TRSP_COST_DTL_MOD_CD, 'CF', 'OF', 'CN', 'ON', 'MT') " ).append("\n"); 
		query.append("                || DECODE(A.TRSP_CRR_MOD_CD, 'TW', 'WT', 'RW', 'WR', 'TR', 'RT' , A.TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("          AND A.CGO_TP_CD = 'M'" ).append("\n"); 
		query.append("          AND A.TRSP_SO_TP_CD = 'M' ), A.LGS_COST_CD )," ).append("\n"); 
		query.append("    FINC_VSL_CD = A.VSL_CD ," ).append("\n"); 
		query.append("    FINC_SKD_VOY_NO = A.SKD_VOY_NO ," ).append("\n"); 
		query.append("    FINC_SKD_DIR_CD = DECODE (A.VSL_CD , 'CNTC', 'M', NVL (MAS_REV_DIR_CONV_FNC (A.SLAN_CD, A.POL_CD, A.SKD_DIR_CD, A.POD_CD), A.SKD_DIR_CD))" ).append("\n"); 
		query.append("WHERE (TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("        SELECT TRSP_SO_OFC_CTY_CD, TRSP_SO_SEQ" ).append("\n"); 
		query.append("        FROM TRS_TRSP_WRK_ORD_PRV_TMP" ).append("\n"); 
		query.append("        WHERE WO_PRV_GRP_SEQ = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("            AND WO_ISS_NO = @[wo_iss_no]" ).append("\n"); 
		query.append("            AND WO_CXL_FLG != 'Y' )" ).append("\n"); 
		query.append("    AND N3PTY_BIL_FLG = 'Y'" ).append("\n"); 

	}
}