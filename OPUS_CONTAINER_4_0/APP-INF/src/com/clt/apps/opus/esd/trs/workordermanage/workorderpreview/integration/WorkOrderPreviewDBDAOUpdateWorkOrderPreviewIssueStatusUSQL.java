/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOUpdateWorkOrderPreviewIssueStatusUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.28 
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

public class WorkOrderPreviewDBDAOUpdateWorkOrderPreviewIssueStatusUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderPreview Issue Status Update
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOUpdateWorkOrderPreviewIssueStatusUSQL(){
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
		query.append("FileName : WorkOrderPreviewDBDAOUpdateWorkOrderPreviewIssueStatusUSQL").append("\n"); 
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
		query.append("UPDATE trs_trsp_wrk_ord_prv_tmp" ).append("\n"); 
		query.append("SET wo_iss_sts_cd = ( " ).append("\n"); 
		query.append("		CASE WHEN(" ).append("\n"); 
		query.append("                    SELECT DISTINCT DECODE(a.trsp_so_sts_cd, 'R', 'C', a.trsp_so_sts_cd)" ).append("\n"); 
		query.append("                    FROM trs_trsp_wrk_ord_prv_tmp a" ).append("\n"); 
		query.append("                    WHERE a.wo_prv_grp_seq = @[wo_prv_grp_seq] " ).append("\n"); 
		query.append("                    AND a.wo_iss_no = @[wo_iss_no] ) IN ('C', 'R') " ).append("\n"); 
		query.append("			THEN 'I' " ).append("\n"); 
		query.append("         	WHEN(" ).append("\n"); 
		query.append("                    SELECT DISTINCT DECODE(a.trsp_so_sts_cd, 'R', 'C', a.trsp_so_sts_cd)" ).append("\n"); 
		query.append("                    FROM trs_trsp_wrk_ord_prv_tmp a" ).append("\n"); 
		query.append("                    WHERE a.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                        AND a.wo_iss_no = @[wo_iss_no]) = 'I'" ).append("\n"); 
		query.append("                        AND NVL((SELECT COUNT(SO.TRSP_SO_OFC_CTY_CD) CNT" ).append("\n"); 
		query.append("					FROM TRS_TRSP_SVC_ORD         SO" ).append("\n"); 
		query.append("						,trs_trsp_wrk_ord_prv_tmp WRK" ).append("\n"); 
		query.append("				 WHERE SO.TRSP_WO_OFC_CTY_CD = WRK.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("					 AND SO.TRSP_WO_SEQ = WRK.TRSP_WO_SEQ" ).append("\n"); 
		query.append("					 AND NVL(SO.TRS_SUB_STS_CD, 'DF') = 'DF'" ).append("\n"); 
		query.append("					 and WRK.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("					 AND WRK.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("					 and wrk.wo_cxl_flg <> 'Y'" ).append("\n"); 
		query.append("					 AND WRK.trsp_so_sts_cd = 'I'), 0) > 0" ).append("\n"); 
		query.append("			THEN 'I' " ).append("\n"); 
		query.append("         	WHEN(" ).append("\n"); 
		query.append("                    SELECT DISTINCT DECODE(a.trsp_so_sts_cd, 'R', 'C', a.trsp_so_sts_cd)" ).append("\n"); 
		query.append("                    FROM trs_trsp_wrk_ord_prv_tmp a" ).append("\n"); 
		query.append("                    WHERE a.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                        AND a.wo_iss_no = @[wo_iss_no]) = 'I'" ).append("\n"); 
		query.append("                        AND NVL((" ).append("\n"); 
		query.append("                                  SELECT COUNT(*) total_cnt" ).append("\n"); 
		query.append("                                  FROM (" ).append("\n"); 
		query.append("                                         SELECT a.trsp_wo_ofc_cty_cd, a.trsp_wo_seq" ).append("\n"); 
		query.append("                                         FROM trs_trsp_wrk_ord_prv_tmp a" ).append("\n"); 
		query.append("                                         WHERE a.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                                            AND a.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("                                            AND ROWNUM = 1 " ).append("\n"); 
		query.append("                                       ) b," ).append("\n"); 
		query.append("                                       trs_trsp_svc_ord c" ).append("\n"); 
		query.append("                                  WHERE b.trsp_wo_ofc_cty_cd = c.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                                      AND b.trsp_wo_seq = c.trsp_wo_seq), 0) = NVL((" ).append("\n"); 
		query.append("                                                                                     SELECT NVL(COUNT(*), 0) total_cnt" ).append("\n"); 
		query.append("                                                                                     FROM trs_trsp_wrk_ord_prv_tmp a" ).append("\n"); 
		query.append("                                                                                     WHERE a.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                                                                                        AND a.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("                                                                                        AND NVL(a.wo_cxl_flg, 'N') = 'N'), 0) " ).append("\n"); 
		query.append("				THEN 'R' " ).append("\n"); 
		query.append("                WHEN(" ).append("\n"); 
		query.append("                        SELECT DISTINCT a.trsp_so_sts_cd" ).append("\n"); 
		query.append("                        FROM trs_trsp_wrk_ord_prv_tmp a" ).append("\n"); 
		query.append("                        WHERE a.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                            AND a.wo_iss_no = @[wo_iss_no] )= 'I'" ).append("\n"); 
		query.append("                            AND NVL((" ).append("\n"); 
		query.append("                        SELECT COUNT(*) total_cnt" ).append("\n"); 
		query.append("                        FROM (" ).append("\n"); 
		query.append("                                SELECT a.trsp_wo_ofc_cty_cd ," ).append("\n"); 
		query.append("                                    a.trsp_wo_seq" ).append("\n"); 
		query.append("                                FROM trs_trsp_wrk_ord_prv_tmp a" ).append("\n"); 
		query.append("                                WHERE a.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                                    AND a.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("                                    AND ROWNUM = 1 " ).append("\n"); 
		query.append("                            ) b ," ).append("\n"); 
		query.append("                            trs_trsp_svc_ord c" ).append("\n"); 
		query.append("                        WHERE b.trsp_wo_ofc_cty_cd = c.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("                            AND b.trsp_wo_seq = c.trsp_wo_seq ), 0) = NVL((" ).append("\n"); 
		query.append("                                                                            SELECT NVL(COUNT(*), 0) total_cnt" ).append("\n"); 
		query.append("                                                                            FROM trs_trsp_wrk_ord_prv_tmp a" ).append("\n"); 
		query.append("                                                                            WHERE a.wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("                                                                                AND a.wo_iss_no = @[wo_iss_no]" ).append("\n"); 
		query.append("                                                                                AND NVL(a.wo_cxl_flg, 'N') = 'Y' ), 0) " ).append("\n"); 
		query.append("				THEN 'N' " ).append("\n"); 
		query.append("        ELSE 'C' " ).append("\n"); 
		query.append("        END )" ).append("\n"); 
		query.append("WHERE wo_prv_grp_seq = @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("  AND wo_iss_no = @[wo_iss_no]" ).append("\n"); 

	}
}