/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchDeletedMVMTListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.04.19 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementFinderDBDAOSearchDeletedMVMTListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_CTM_0415 : 삭제된 Movement List 조회
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchDeletedMVMTListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("check_digit",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_cntrno",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchDeletedMVMTListVORSQL").append("\n"); 
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
		query.append("SELECT   A.CNMV_CYC_NO," ).append("\n"); 
		query.append("A.CNMV_CO_CD," ).append("\n"); 
		query.append("A.CNMV_STS_CD," ).append("\n"); 
		query.append("A.MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("A.ORG_YD_CD," ).append("\n"); 
		query.append("A.DEST_YD_CD," ).append("\n"); 
		query.append("TO_CHAR (A.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("A.FDR_VSL_CD||A.FDR_SKD_VOY_NO||A.FDR_SKD_DIR_CD AS FDR_CD," ).append("\n"); 
		query.append("A.BKG_KNT," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.BL_NO," ).append("\n"); 
		query.append("DECODE (A.FCNTR_FLG, 'Y', 'F', 'N', 'M', A.FCNTR_FLG) AS FCNTR_FLG," ).append("\n"); 
		query.append("DECODE (A.OB_CNTR_FLG, 'Y', 'O', 'N', 'I', A.OB_CNTR_FLG) AS OB_CNTR_FLG," ).append("\n"); 
		query.append("A.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("A.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("A.CNTR_DMG_FLG," ).append("\n"); 
		query.append("A.CNTR_DISP_FLG," ).append("\n"); 
		query.append("A.IMDT_EXT_FLG," ).append("\n"); 
		query.append("A.CNTR_RFUB_FLG," ).append("\n"); 
		query.append("A.SPCL_CGO_FLG," ).append("\n"); 
		query.append("A.VNDR_SEQ," ).append("\n"); 
		query.append("B.VNDR_ABBR_NM," ).append("\n"); 
		query.append("A.MVMT_TRSP_MOD_CD," ).append("\n"); 
		query.append("TRIM (A.CHSS_NO) AS CHSS_NO," ).append("\n"); 
		query.append("TRIM (A.MGST_NO) AS MGST_NO," ).append("\n"); 
		query.append("TRIM (A.CNTR_SEAL_NO) AS CNTR_SEAL_NO," ).append("\n"); 
		query.append("TRIM (A.WBL_NO) AS WBL_NO," ).append("\n"); 
		query.append("TRIM (A.PKUP_NO) AS PKUP_NO," ).append("\n"); 
		query.append("TO_CHAR (A.UPD_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS UPD_LOCL_DT," ).append("\n"); 
		query.append("TO_CHAR (A.CRE_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS CRE_LOCL_DT," ).append("\n"); 
		query.append("TO_CHAR (A.UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT," ).append("\n"); 
		query.append("TO_CHAR (A.CRE_DT, 'YYYY-MM-DD HH24:MI') AS CRE_DT," ).append("\n"); 
		query.append("TO_CHAR (A.DELT_DT, 'YYYY-MM-DD HH24:MI') AS DELT_DT," ).append("\n"); 
		query.append("A.DELT_USR_ID," ).append("\n"); 
		query.append("C.USR_NM," ).append("\n"); 
		query.append("A.CNMV_RMK" ).append("\n"); 
		query.append("FROM CTM_MVMT_CORR A," ).append("\n"); 
		query.append("MDM_VENDOR B," ).append("\n"); 
		query.append("COM_USER C" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ(+)" ).append("\n"); 
		query.append("AND A.DELT_USR_ID = C.USR_ID(+)" ).append("\n"); 
		query.append("#if (${p_cntrno} != '')" ).append("\n"); 
		query.append("AND A.CNTR_NO = @[p_cntrno]||@[check_digit]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_date1} != '' && ${p_date2} != '')" ).append("\n"); 
		query.append("AND A.DELT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.DELT_DT" ).append("\n"); 

	}
}