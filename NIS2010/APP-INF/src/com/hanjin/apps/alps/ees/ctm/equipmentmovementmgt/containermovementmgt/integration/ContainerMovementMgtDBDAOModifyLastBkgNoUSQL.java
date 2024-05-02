/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOModifyLastBkgNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOModifyLastBkgNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Last booking No를 update하기 위한 작업
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOModifyLastBkgNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("last_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnmv_cyc_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("last_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOModifyLastBkgNoUSQL").append("\n"); 
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
		query.append("UPDATE CTM_MOVEMENT CTM " ).append("\n"); 
		query.append("SET CTM.LST_BKG_NO = @[last_bkg_no]," ).append("\n"); 
		query.append("  CTM.LST_BL_NO = @[last_bl_no]," ).append("\n"); 
		query.append("  CTM.UPD_USR_ID = 'LSTBKG'" ).append("\n"); 
		query.append("WHERE CTM.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("  AND (CTM.LST_BKG_NO IS NULL OR CTM.LST_BKG_NO <> @[last_bkg_no] OR CTM.LST_BL_NO IS NULL OR CTM.LST_BL_NO <> @[last_bl_no])" ).append("\n"); 
		query.append("  AND CTM.CNMV_YR || TO_CHAR(CTM.CNMV_SEQ, '00000') || CTM.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("        >= CASE WHEN @[bkg_cgo_tp_cd] = 'F'" ).append("\n"); 
		query.append("                  THEN NVL(" ).append("\n"); 
		query.append("                         (SELECT /*+ INDEX_ASC(MOV XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                            MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                          FROM CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("                          WHERE MOV.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("                            AND MOV.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("                            AND MOV.MVMT_STS_CD IN ('OP', 'OC')" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("                         )," ).append("\n"); 
		query.append("                         NVL(" ).append("\n"); 
		query.append("                           (SELECT /*+ INDEX_ASC(MOV XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                              MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                            FROM CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("                            WHERE MOV.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("                              AND MOV.CNMV_CYC_NO = (TO_NUMBER(@[cnmv_cyc_no]) - 1)" ).append("\n"); 
		query.append("                              AND MOV.MVMT_STS_CD IN ('OP', 'OC')" ).append("\n"); 
		query.append("                              AND ROWNUM = 1" ).append("\n"); 
		query.append("                           )," ).append("\n"); 
		query.append("                           (SELECT /*+ INDEX_ASC(MOV XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                              MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                            FROM CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("                            WHERE MOV.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("                              AND MOV.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("                              AND ROWNUM = 1" ).append("\n"); 
		query.append("                           )" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                ELSE NVL(" ).append("\n"); 
		query.append("                       (SELECT /*+ INDEX_ASC(MOV XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                          MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                        FROM CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("                        WHERE MOV.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("                          AND MOV.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("                          AND MOV.MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("                          AND ROWNUM = 1" ).append("\n"); 
		query.append("                       )," ).append("\n"); 
		query.append("                       NVL(" ).append("\n"); 
		query.append("                         (SELECT /*+ INDEX_ASC(MOV XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                            MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                          FROM CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("                          WHERE MOV.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("                            AND MOV.CNMV_CYC_NO = (TO_NUMBER(@[cnmv_cyc_no]) - 1)" ).append("\n"); 
		query.append("                            AND MOV.MVMT_STS_CD = 'VL'" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("                         )," ).append("\n"); 
		query.append("                         (SELECT /*+ INDEX_ASC(MOV XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                            MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("                          FROM CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("                          WHERE MOV.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("                            AND MOV.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("                            AND ROWNUM = 1" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("           END" ).append("\n"); 
		query.append("  AND CTM.CNMV_YR || TO_CHAR(CTM.CNMV_SEQ, '00000') || CTM.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("        <= NVL(" ).append("\n"); 
		query.append("             (SELECT /*+ INDEX_ASC(MOV XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("              FROM CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("              WHERE MOV.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("                AND MOV.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("                AND MOV.MVMT_STS_CD = 'MT'" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("             )," ).append("\n"); 
		query.append("             (SELECT /*+ INDEX_DESC(MOV XFN1CTM_MOVEMENT) */" ).append("\n"); 
		query.append("                MOV.CNMV_YR || TO_CHAR(MOV.CNMV_SEQ, '00000') || MOV.CNMV_SPLIT_NO" ).append("\n"); 
		query.append("              FROM CTM_MOVEMENT MOV" ).append("\n"); 
		query.append("              WHERE MOV.CNTR_NO = CTM.CNTR_NO" ).append("\n"); 
		query.append("                AND MOV.CNMV_CYC_NO = @[cnmv_cyc_no]" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("           )" ).append("\n"); 

	}
}