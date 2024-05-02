/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusReportDBDAOBkgCMCroChkListinVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.09.10 강동윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kang dong yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOBkgCMCroChkListinVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public StatusReportDBDAOBkgCMCroChkListinVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usa_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnd_cstms_file_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgCMCroChkListinVORSQL").append("\n"); 
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
		query.append("SELECT A.BKG_NO" ).append("\n"); 
		query.append(",A.BL_NO" ).append("\n"); 
		query.append(",A.USA_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",A.CND_CSTMS_FILE_CD" ).append("\n"); 
		query.append(",B.OBL_ISS_OFC_CD" ).append("\n"); 
		query.append(",B.OBL_ISS_USR_ID" ).append("\n"); 
		query.append(",DECODE(NVL(D.CUST_NM,'N'),'N','N','Y')            AS CUST_NM_S" ).append("\n"); 
		query.append(",DECODE(NVL(D.CUST_ADDR,'N'),'N','N','Y')          AS CUST_ADDR_S" ).append("\n"); 
		query.append(",DECODE(NVL(D.CUST_CTY_NM,'N'),'N','N','Y')        AS CUST_CTY_NM_S" ).append("\n"); 
		query.append(",DECODE(NVL(D.CSTMS_DECL_CNT_CD,'N'),'N','N','Y')  AS CSTMS_DECL_CNT_CD_S" ).append("\n"); 
		query.append(",DECODE(NVL(D.CUST_ZIP_ID,'N'),'N','N','Y')        AS CUST_ZIP_ID_S" ).append("\n"); 
		query.append(",DECODE(NVL(E.CUST_NM,'N'),'N','N','Y')            AS CUST_NM_C" ).append("\n"); 
		query.append(",DECODE(NVL(E.CUST_ADDR,'N'),'N','N','Y')          AS CUST_ADDR_C" ).append("\n"); 
		query.append(",DECODE(NVL(E.CUST_CTY_NM,'N'),'N','N','Y')        AS CUST_CTY_NM_C" ).append("\n"); 
		query.append(",DECODE(NVL(E.CSTMS_DECL_CNT_CD,'N'),'N','N','Y')  AS CSTMS_DECL_CNT_CD_C" ).append("\n"); 
		query.append(",DECODE(NVL(E.CUST_STE_CD,'N'),'N','N','Y')		 AS CUST_STE_CD_C" ).append("\n"); 
		query.append(",DECODE(NVL(E.CUST_ZIP_ID,'N'),'N','N','Y')        AS CUST_ZIP_ID_C" ).append("\n"); 
		query.append(",DECODE(NVL(F.CUST_NM,'N'),'N','N','Y')            AS CUST_NM_N" ).append("\n"); 
		query.append(",DECODE(NVL(F.CUST_ADDR,'N'),'N','N','Y')          AS CUST_ADDR_N" ).append("\n"); 
		query.append(",DECODE(NVL(F.CUST_CTY_NM,'N'),'N','N','Y')        AS CUST_CTY_NM_N" ).append("\n"); 
		query.append(",DECODE(NVL(F.CSTMS_DECL_CNT_CD,'N'),'N','N','Y')  AS CSTMS_DECL_CNT_CD_N" ).append("\n"); 
		query.append(",DECODE(NVL(F.CUST_STE_CD,'N'),'N','N','Y')		 AS CUST_STE_CD_N" ).append("\n"); 
		query.append(",DECODE(NVL(F.CUST_ZIP_ID,'N'),'N','N','Y')        AS CUST_ZIP_ID_N" ).append("\n"); 
		query.append(",C.PCK_QTY                                         AS PCK_QTY_DA" ).append("\n"); 
		query.append(",C.ACT_WGT" ).append("\n"); 
		query.append(",C.MEAS_QTY                                        AS MEAS_QTY_DA" ).append("\n"); 
		query.append(",DECODE(C.PCK_QTY,G.PCK_QTY,'Y','N')               AS PCK_QTY_CHK" ).append("\n"); 
		query.append(",DECODE(C.ACT_WGT,G.CNTR_MF_WGT,'Y','N')           AS ACT_WET_CHK" ).append("\n"); 
		query.append(",DECODE(C.MEAS_QTY,G.MEAS_QTY,'Y','N')             AS MEAS_QTY_CHK" ).append("\n"); 
		query.append(",G.PCK_QTY                                         AS PCK_QTY_CM" ).append("\n"); 
		query.append(",G.CNTR_MF_WGT" ).append("\n"); 
		query.append(",G.MEAS_QTY                                        AS MEAS_QTY_CM" ).append("\n"); 
		query.append(",DECODE(NVL(G.CNTR_MF_MK_DESC,'N'),'N','N','Y')    AS CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",DECODE(NVL(G.CNTR_MF_GDS_DESC,'N'),'N','N','Y')   AS CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",H.CNTR_NO" ).append("\n"); 
		query.append(",H.PCK_QTY                                         AS PCK_QTY_CO" ).append("\n"); 
		query.append(",H.CNTR_WGT" ).append("\n"); 
		query.append(",H.MEAS_QTY                                        AS MEAS_QTY_CO" ).append("\n"); 
		query.append(",DECODE(NVL(I.CNTR_SEAL_SEQ,''),'','N','Y')        AS CNTR_SEAL_SEQ" ).append("\n"); 
		query.append(",'' VSL_CD" ).append("\n"); 
		query.append(",'' SKD_VOY_NO" ).append("\n"); 
		query.append(",'' SKD_DIR_CD" ).append("\n"); 
		query.append(",'' POL_CD" ).append("\n"); 
		query.append(",'' POL_YD_CD" ).append("\n"); 
		query.append(",'' POD_CD" ).append("\n"); 
		query.append(",'' POD_YD_CD" ).append("\n"); 
		query.append(",'' CUST_CNT_CD" ).append("\n"); 
		query.append(",'' CUST_SEQ" ).append("\n"); 
		query.append(",'' CHK_ERR" ).append("\n"); 
		query.append(",'' BKG_OFC_CD" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append(",'' OB_SREP_CD" ).append("\n"); 
		query.append(",'' TAB_ITEM" ).append("\n"); 
		query.append(",'' B_BL_NO" ).append("\n"); 
		query.append(",'' B_USA_CSTMS_FILE_NO" ).append("\n"); 
		query.append(",'' B_HBL_NO" ).append("\n"); 
		query.append(",'' B_CUST_NM_S" ).append("\n"); 
		query.append(",'' B_CUST_ADDR_S" ).append("\n"); 
		query.append(",'' B_CUST_NM_C" ).append("\n"); 
		query.append(",'' B_CUST_ADDR_C" ).append("\n"); 
		query.append(",'' B_CUST_NM_N" ).append("\n"); 
		query.append(",'' B_CUST_ADDR_N" ).append("\n"); 
		query.append(",'' B_PCK_QTY_DA" ).append("\n"); 
		query.append(",'' B_HBL_WGT_DA" ).append("\n"); 
		query.append(",'' B_MEAS_QTY_DA" ).append("\n"); 
		query.append(",'' B_PCK_QTY_CHK" ).append("\n"); 
		query.append(",'' B_HBL_WET_CHK" ).append("\n"); 
		query.append(",'' B_MEAS_QTY_CHK" ).append("\n"); 
		query.append(",'' B_PCK_QTY_CM" ).append("\n"); 
		query.append(",'' B_CNTR_WGT_CM" ).append("\n"); 
		query.append(",'' B_MEAS_QTY_CM" ).append("\n"); 
		query.append(",'' B_CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",'' B_CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",'' B_CNTR_MF_NO" ).append("\n"); 
		query.append(",'' B_CNTR_NO" ).append("\n"); 
		query.append(",'' B_CNTR_SEAL_NO" ).append("\n"); 
		query.append(",'' B_PCK_QTY_CO" ).append("\n"); 
		query.append(",'' B_CNTR_WGT_CO" ).append("\n"); 
		query.append(",'' B_MEAS_QTY_CO" ).append("\n"); 
		query.append("FROM BKG_BOOKING      A" ).append("\n"); 
		query.append(",BKG_BL_ISS       B" ).append("\n"); 
		query.append(",BKG_BL_DOC       C" ).append("\n"); 
		query.append(",BKG_CUSTOMER     D" ).append("\n"); 
		query.append(",BKG_CUSTOMER     E" ).append("\n"); 
		query.append(",BKG_CUSTOMER     F" ).append("\n"); 
		query.append(",BKG_CNTR_MF_DESC G" ).append("\n"); 
		query.append(",BKG_CONTAINER    H" ).append("\n"); 
		query.append(",BKG_CNTR_SEAL_NO I" ).append("\n"); 
		query.append("WHERE A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = F.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = G.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = H.BKG_NO" ).append("\n"); 
		query.append("AND A.BKG_NO = I.BKG_NO" ).append("\n"); 
		query.append("AND D.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND E.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("AND F.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("AND A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("AND A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${usa_cstms_file_cd} != '')" ).append("\n"); 
		query.append("AND A.USA_CSTMS_FILE_CD = @[usa_cstms_file_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnd_cstms_file_cd} != '')" ).append("\n"); 
		query.append("AND A.CND_CSTMS_FILE_CD = @[cnd_cstms_file_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("AND A.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '')" ).append("\n"); 
		query.append("AND A.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${obl_iss_ofc_cd} != '')" ).append("\n"); 
		query.append("AND B.OBL_ISS_OFC_CD = @[obl_iss_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${obl_iss_usr_id} != '')" ).append("\n"); 
		query.append("AND B.OBL_ISS_USR_ID = @[obl_iss_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}