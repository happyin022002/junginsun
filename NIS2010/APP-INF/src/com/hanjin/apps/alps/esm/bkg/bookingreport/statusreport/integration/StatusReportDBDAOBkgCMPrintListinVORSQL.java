/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StatusReportDBDAOBkgCMPrintListinVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StatusReportDBDAOBkgCMPrintListinVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public StatusReportDBDAOBkgCMPrintListinVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.integration").append("\n"); 
		query.append("FileName : StatusReportDBDAOBkgCMPrintListinVORSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO" ).append("\n"); 
		query.append("      ,A.BKG_NO" ).append("\n"); 
		query.append("	  ,A.BL_NO_TP" ).append("\n"); 
		query.append("      ,A.BL_TP_CD" ).append("\n"); 
		query.append("      ,A.OB_SREP_CD" ).append("\n"); 
		query.append("      ,A.POL_CD" ).append("\n"); 
		query.append("      ,A.RCV_TERM_CD" ).append("\n"); 
		query.append("	  ,A.DE_TERM_CD" ).append("\n"); 
		query.append("	  ,(SELECT USR_NM FROM COM_USER WHERE USR_ID = A.DOC_USR_ID) AS DOC_USR_NM" ).append("\n"); 
		query.append("      ,A.DOC_USR_ID" ).append("\n"); 
		query.append("      ,B.PCK_QTY" ).append("\n"); 
		query.append("      ,NVL(B.PCK_QTY,0) PCK_QTY" ).append("\n"); 
		query.append("      ,TO_CHAR(NVL(B.CNTR_MF_WGT,0),999999999999990.099) CNTR_MF_WGT" ).append("\n"); 
		query.append("      ,TO_CHAR(NVL(B.MEAS_QTY,0),999999999999990.099) MEAS_QTY" ).append("\n"); 
		query.append("      ,B.RD_CGO_FLG" ).append("\n"); 
		query.append("      ,DECODE(B.DCGO_FLG,'N','','Y') DCGO_FLG" ).append("\n"); 
		query.append("      ,DECODE(B.AWK_CGO_FLG,'N','','Y') AWK_CGO_FLG" ).append("\n"); 
		query.append("      ,DECODE(B.HNGR_FLG,'N','','Y') HNGR_FLG" ).append("\n"); 
		query.append("      ,REPLACE(B.CNTR_MF_GDS_DESC,CHR(13) || CHR(10),' ') CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("      ,REPLACE(B.CNTR_MF_MK_DESC,CHR(13) || CHR(10),' ') CNTR_MF_MK_DESC" ).append("\n"); 
		query.append("      ,B.HAMO_TRF_CD" ).append("\n"); 
		query.append("      ,B.PO_NO" ).append("\n"); 
		query.append("      ,B.CMDT_HS_CD" ).append("\n"); 
		query.append("      ,C.ADV_SHTG_CD" ).append("\n"); 
		query.append("      ,C.CNTR_NO" ).append("\n"); 
		query.append("      ,C.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("      ,BKG_JOIN_FNC(CURSOR( SELECT CNTR_SEAL_NO FROM BKG_CNTR_SEAL_NO WHERE BKG_NO = C.BKG_NO AND CNTR_NO = C.CNTR_NO)) CNTR_SEAL_NO" ).append("\n"); 
		query.append("      ,E.CUST_CNT_CD" ).append("\n"); 
		query.append("      ,E.CUST_SEQ" ).append("\n"); 
		query.append("	  ,REPLACE(E.CUST_NM,CHR(13) || CHR(10),' ') CUST_NM" ).append("\n"); 
		query.append("	  ,'CM' TAB_TP" ).append("\n"); 
		query.append("  FROM BKG_BOOKING          A" ).append("\n"); 
		query.append("      ,BKG_CNTR_MF_DESC     B" ).append("\n"); 
		query.append("      ,BKG_CONTAINER        C" ).append("\n"); 
		query.append("      ,BKG_VVD              D" ).append("\n"); 
		query.append("      ,BKG_CUSTOMER         E" ).append("\n"); 
		query.append(" WHERE D.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND D.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND D.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("   AND A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("   AND E.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND C.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("   AND C.CNTR_NO = B.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND C.CNTR_NO IS NOT NULL" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND D.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_yd_cd} != '') " ).append("\n"); 
		query.append("   AND D.POL_YD_CD = @[pol_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("   AND D.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_yd_cd} != '') " ).append("\n"); 
		query.append("   AND D.POD_YD_CD = @[pod_yd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rcv_term_cd} != '') " ).append("\n"); 
		query.append("   AND A.RCV_TERM_CD = @[rcv_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_term_cd} != '') " ).append("\n"); 
		query.append("   AND A.DE_TERM_CD = @[de_term_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd} != '') " ).append("\n"); 
		query.append("   AND A.BKG_OFC_CD = @[bkg_ofc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cre_usr_id} != '') " ).append("\n"); 
		query.append("   AND A.CRE_USR_ID = @[cre_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("   AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("   AND A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ob_srep_cd} != '') " ).append("\n"); 
		query.append("   AND A.OB_SREP_CD = @[ob_srep_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_no} != '') " ).append("\n"); 
		query.append("   AND C.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_cnt_cd} != '') " ).append("\n"); 
		query.append("   AND E.CUST_CNT_CD(+) = @[cust_cnt_cd]" ).append("\n"); 
		query.append("   AND E.CUST_SEQ(+)	= @[cust_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cust_nm} != '')" ).append("\n"); 
		query.append("   AND E.CUST_NM LIKE '%' || @[cust_nm] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" ORDER BY C.CNTR_NO ASC" ).append("\n"); 
		query.append(" --ORDER BY A.BL_NO ASC" ).append("\n"); 

	}
}