/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOMstCtmMvmtIrrInsertCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.29
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.01.29 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOMstCtmMvmtIrrInsertCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM_MVMT_IRR에 데이타 입력
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOMstCtmMvmtIrrInsertCSQL(){
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
		params.put("cntr_bkg_atch_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOMstCtmMvmtIrrInsertCSQL").append("\n"); 
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
		query.append("INSERT INTO CTM_MVMT_IRR" ).append("\n"); 
		query.append("            (CNTR_NO," ).append("\n"); 
		query.append("             CNMV_YR," ).append("\n"); 
		query.append("             CNMV_ID_NO," ).append("\n"); 
		query.append("             CNTR_BKG_ATCH_CD," ).append("\n"); 
		query.append("             CNMV_CYC_NO," ).append("\n"); 
		query.append("             MVMT_IRR_SEQ," ).append("\n"); 
		query.append("             CNTR_TPSZ_CD," ).append("\n"); 
		query.append("             CNMV_STS_CD," ).append("\n"); 
		query.append("             CNMV_EVNT_DT," ).append("\n"); 
		query.append("             ORG_YD_CD," ).append("\n"); 
		query.append("             BKG_NO," ).append("\n"); 
		query.append("             PRE_CNMV_YR," ).append("\n"); 
		query.append("             PRE_CNMV_ID_NO," ).append("\n"); 
		query.append("             PRE_CNMV_STS_CD," ).append("\n"); 
		query.append("             PRE_CNMV_EVNT_DT," ).append("\n"); 
		query.append("             PRE_ORG_YD_CD," ).append("\n"); 
		query.append("             PRE_DEST_YD_CD," ).append("\n"); 
		query.append("             PRE_BKG_NO," ).append("\n"); 
		query.append("             CNMV_IRR_STL_FLG," ).append("\n"); 
		query.append("             OFC_CD," ).append("\n"); 
		query.append("             CRE_USR_ID," ).append("\n"); 
		query.append("             CRE_DT," ).append("\n"); 
		query.append("             UPD_USR_ID" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("   (SELECT /*+ LEADING(A) USE_NL(B) INDEX_DESC(A XUK1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("           A.CNTR_NO," ).append("\n"); 
		query.append("           A.CNMV_YR," ).append("\n"); 
		query.append("           A.CNMV_ID_NO," ).append("\n"); 
		query.append("           @[cntr_bkg_atch_cd]," ).append("\n"); 
		query.append("           A.CNMV_CYC_NO," ).append("\n"); 
		query.append("           (SELECT NVL (MAX (MVMT_IRR_SEQ), 0) + 1" ).append("\n"); 
		query.append("              FROM CTM_MVMT_IRR" ).append("\n"); 
		query.append("             WHERE CNTR_NO = @[cntr_no])," ).append("\n"); 
		query.append("           A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("           A.MVMT_STS_CD," ).append("\n"); 
		query.append("           A.CNMV_EVNT_DT," ).append("\n"); 
		query.append("           A.ORG_YD_CD," ).append("\n"); 
		query.append("           A.BKG_NO," ).append("\n"); 
		query.append("           B.CNMV_YR," ).append("\n"); 
		query.append("           B.CNMV_ID_NO," ).append("\n"); 
		query.append("           B.MVMT_STS_CD," ).append("\n"); 
		query.append("           B.CNMV_EVNT_DT," ).append("\n"); 
		query.append("           B.ORG_YD_CD," ).append("\n"); 
		query.append("           B.DEST_YD_CD," ).append("\n"); 
		query.append("           B.BKG_NO," ).append("\n"); 
		query.append("           'N'," ).append("\n"); 
		query.append("           A.OFC_CD," ).append("\n"); 
		query.append("           A.CRE_USR_ID," ).append("\n"); 
		query.append("           SYSDATE," ).append("\n"); 
		query.append("           CRE_USR_ID" ).append("\n"); 
		query.append("      FROM CTM_MOVEMENT A," ).append("\n"); 
		query.append("           (SELECT ROWNUM RON," ).append("\n"); 
		query.append("                   CNTR_NO," ).append("\n"); 
		query.append("                   CNMV_YR," ).append("\n"); 
		query.append("                   CNMV_ID_NO," ).append("\n"); 
		query.append("                   CNMV_CYC_NO," ).append("\n"); 
		query.append("                   IDS," ).append("\n"); 
		query.append("                   CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                   MVMT_STS_CD," ).append("\n"); 
		query.append("                   CNMV_EVNT_DT," ).append("\n"); 
		query.append("                   ORG_YD_CD," ).append("\n"); 
		query.append("                   BKG_NO," ).append("\n"); 
		query.append("                   DEST_YD_CD" ).append("\n"); 
		query.append("              FROM (SELECT /*+ INDEX_DESC (CTM_MOVEMENT XUK1CTM_MOVEMENT ) */" ).append("\n"); 
		query.append("                           ROWNUM RON," ).append("\n"); 
		query.append("                           CNTR_NO," ).append("\n"); 
		query.append("                           CNMV_YR," ).append("\n"); 
		query.append("                           CNMV_ID_NO," ).append("\n"); 
		query.append("                           CNMV_CYC_NO," ).append("\n"); 
		query.append("                           (SELECT NVL (MAX (MVMT_IRR_SEQ), 0)" ).append("\n"); 
		query.append("                              FROM CTM_MVMT_IRR" ).append("\n"); 
		query.append("                             WHERE CNTR_NO = @[cntr_no]) IDS," ).append("\n"); 
		query.append("                           CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                           MVMT_STS_CD," ).append("\n"); 
		query.append("                           CNMV_EVNT_DT," ).append("\n"); 
		query.append("                           ORG_YD_CD," ).append("\n"); 
		query.append("                           BKG_NO," ).append("\n"); 
		query.append("                           DEST_YD_CD" ).append("\n"); 
		query.append("                      FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("                     WHERE CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("                       AND NVL (MVMT_CRE_TP_CD, 'C') != 'A'" ).append("\n"); 
		query.append("                       AND ROWNUM < 3)" ).append("\n"); 
		query.append("             WHERE RON = 2) B" ).append("\n"); 
		query.append("     WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("       AND A.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("       AND ROWNUM = 1) " ).append("\n"); 

	}
}