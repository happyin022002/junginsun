/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewGroupWOListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.08 
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

public class WorkOrderPreviewDBDAOSearchWorkOrderPreviewGroupWOListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchWorkOrderPreviewGroupWOList
	  * </pre>
	  */
	public WorkOrderPreviewDBDAOSearchWorkOrderPreviewGroupWOListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.integration").append("\n"); 
		query.append("FileName : WorkOrderPreviewDBDAOSearchWorkOrderPreviewGroupWOListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("B.TRSP_SO_SEQ," ).append("\n"); 
		query.append("B.TRSP_SO_STS_CD," ).append("\n"); 
		query.append("MIN(ROWNUM) over" ).append("\n"); 
		query.append("(PARTITION BY B.TRSP_SO_TP_CD," ).append("\n"); 
		query.append("B.WO_FMT_TP_CD," ).append("\n"); 
		query.append("B.VNDR_SEQ," ).append("\n"); 
		query.append("B.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("B.FM_NOD_CD," ).append("\n"); 
		query.append("B.VIA_NOD_CD," ).append("\n"); 
		query.append("B.DOR_NOD_CD," ).append("\n"); 
		query.append("B.DOR_DE_ADDR," ).append("\n"); 
		query.append("B.TO_NOD_CD," ).append("\n"); 
		query.append("B.FDR_VSL_CD||B.FDR_SKD_VOY_NO||B.FDR_SKD_DIR_CD," ).append("\n"); 
		query.append("B.IB_VVD_CD" ).append("\n"); 
		query.append("#if(${wo_prv_grp_bl_flg} == \"Y\")" ).append("\n"); 
		query.append(",B.BL_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY 	 B.TRSP_SO_TP_CD," ).append("\n"); 
		query.append("B.WO_FMT_TP_CD," ).append("\n"); 
		query.append("B.VNDR_SEQ," ).append("\n"); 
		query.append("B.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("B.FM_NOD_CD," ).append("\n"); 
		query.append("B.VIA_NOD_CD," ).append("\n"); 
		query.append("B.DOR_NOD_CD," ).append("\n"); 
		query.append("B.DOR_DE_ADDR," ).append("\n"); 
		query.append("B.TO_NOD_CD," ).append("\n"); 
		query.append("B.FDR_VSL_CD||B.FDR_SKD_VOY_NO||B.FDR_SKD_DIR_CD," ).append("\n"); 
		query.append("B.IB_VVD_CD" ).append("\n"); 
		query.append("#if(${wo_prv_grp_bl_flg} == \"Y\")" ).append("\n"); 
		query.append(",B.BL_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") WO_ISS_NO," ).append("\n"); 
		query.append("B.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("B.TRSP_WO_SEQ," ).append("\n"); 
		query.append("B.WO_FMT_TP_CD," ).append("\n"); 
		query.append("COMMCODE_PKG.GET_COMDTL_NAME_FNC('CD00879',B.WO_FMT_TP_CD) WO_FMT_TP_NM	," ).append("\n"); 
		query.append("B.TRSP_SO_CMB_TP_CD," ).append("\n"); 
		query.append("B.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("B.CGO_TP_CD," ).append("\n"); 
		query.append("B.VNDR_SEQ," ).append("\n"); 
		query.append("B.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("B.FM_NOD_CD," ).append("\n"); 
		query.append("B.VIA_NOD_CD," ).append("\n"); 
		query.append("B.DOR_NOD_CD," ).append("\n"); 
		query.append("B.TO_NOD_CD," ).append("\n"); 
		query.append("B.FDR_VSL_CD," ).append("\n"); 
		query.append("B.FDR_SKD_VOY_NO," ).append("\n"); 
		query.append("B.FDR_SKD_DIR_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CASE" ).append("\n"); 
		query.append("WHEN A.TRSP_SO_CMB_TP_CD IS NULL" ).append("\n"); 
		query.append("AND A.TRSP_COST_DTL_MOD_CD IN ('CY','DR')" ).append("\n"); 
		query.append("AND A.CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND A.TRSP_SO_TP_CD IN ('Y', 'S')" ).append("\n"); 
		query.append("THEN 'NC'" ).append("\n"); 
		query.append("WHEN A.TRSP_SO_CMB_TP_CD = 'CF'" ).append("\n"); 
		query.append("AND A.TRSP_COST_DTL_MOD_CD IN ('CY','DR')" ).append("\n"); 
		query.append("AND A.CGO_TP_CD IN ('F','M')" ).append("\n"); 
		query.append("AND A.TRSP_SO_TP_CD IN ('Y', 'S')" ).append("\n"); 
		query.append("THEN 'CC'" ).append("\n"); 
		query.append("WHEN A.TRSP_SO_CMB_TP_CD = 'FF'" ).append("\n"); 
		query.append("AND A.TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("AND A.CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND A.TRSP_SO_TP_CD IN ('Y', 'S')" ).append("\n"); 
		query.append("THEN 'IB'" ).append("\n"); 
		query.append("WHEN A.TRSP_SO_CMB_TP_CD = 'FF'" ).append("\n"); 
		query.append("AND A.TRSP_COST_DTL_MOD_CD = 'CY'" ).append("\n"); 
		query.append("AND A.CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("AND A.TRSP_SO_TP_CD IN ('Y', 'S')" ).append("\n"); 
		query.append("THEN 'CY'" ).append("\n"); 
		query.append("WHEN A.TRSP_SO_CMB_TP_CD = 'FM'" ).append("\n"); 
		query.append("AND A.TRSP_COST_DTL_MOD_CD = 'CY'" ).append("\n"); 
		query.append("AND A.CGO_TP_CD IN ('F','M')" ).append("\n"); 
		query.append("AND A.TRSP_SO_TP_CD IN ('Y', 'S')" ).append("\n"); 
		query.append("THEN 'CM'" ).append("\n"); 
		query.append("WHEN (A.TRSP_SO_CMB_TP_CD IS NULL OR A.TRSP_SO_CMB_TP_CD='CF')" ).append("\n"); 
		query.append("AND A.TRSP_COST_DTL_MOD_CD IN ('ER','CN','CF')" ).append("\n"); 
		query.append("AND A.CGO_TP_CD = 'M'" ).append("\n"); 
		query.append("AND A.TRSP_SO_TP_CD IN ('M', 'S')" ).append("\n"); 
		query.append("THEN 'MM'" ).append("\n"); 
		query.append("WHEN A.TRSP_SO_TP_CD = 'H'" ).append("\n"); 
		query.append("THEN 'MM'" ).append("\n"); 
		query.append("WHEN A.TRSP_SO_TP_CD = 'O'" ).append("\n"); 
		query.append("AND A.TRSP_COST_DTL_MOD_CD IN ('ER', 'CN', 'CF')" ).append("\n"); 
		query.append("THEN 'MM'" ).append("\n"); 
		query.append("WHEN A.TRSP_SO_TP_CD = 'O'" ).append("\n"); 
		query.append("AND A.TRSP_COST_DTL_MOD_CD NOT IN ('ER', 'CN', 'CF')" ).append("\n"); 
		query.append("THEN 'NC'" ).append("\n"); 
		query.append("ELSE 'NC'" ).append("\n"); 
		query.append("END WO_FMT_TP_CD," ).append("\n"); 
		query.append("A.TRSP_SO_TP_CD," ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_SO_SEQ," ).append("\n"); 
		query.append("A.TRSP_SO_CMB_TP_CD," ).append("\n"); 
		query.append("A.TRSP_SO_STS_CD," ).append("\n"); 
		query.append("A.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("A.TRSP_WO_SEQ," ).append("\n"); 
		query.append("A.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("A.CGO_TP_CD," ).append("\n"); 
		query.append("NVL(C.VNDR_SEQ, A.VNDR_SEQ) VNDR_SEQ," ).append("\n"); 
		query.append("A.TRSP_CRR_MOD_CD," ).append("\n"); 
		query.append("A.FM_NOD_CD," ).append("\n"); 
		query.append("A.VIA_NOD_CD," ).append("\n"); 
		query.append("A.DOR_NOD_CD," ).append("\n"); 
		query.append("A.TO_NOD_CD," ).append("\n"); 
		query.append("A.FDR_VSL_CD," ).append("\n"); 
		query.append("A.FDR_SKD_VOY_NO," ).append("\n"); 
		query.append("A.FDR_SKD_DIR_CD," ).append("\n"); 
		query.append("A.IB_VVD_CD," ).append("\n"); 
		query.append("A.DOR_DE_ADDR," ).append("\n"); 
		query.append("A.BL_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD A										," ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD_PRV_TMP C" ).append("\n"); 
		query.append("WHERE C.WO_PRV_GRP_SEQ 										= @[wo_prv_grp_seq]" ).append("\n"); 
		query.append("AND C.WO_ISS_NO		 										= 1" ).append("\n"); 
		query.append("AND A.TRSP_SO_OFC_CTY_CD	= C.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.TRSP_SO_SEQ 			= C.TRSP_SO_SEQ" ).append("\n"); 
		query.append("#if($sonumberArr.size() > 0)" ).append("\n"); 
		query.append("AND ( (A.TRSP_SO_OFC_CTY_CD, A.TRSP_SO_SEQ) IN (" ).append("\n"); 
		query.append("#foreach( ${key} in ${sonumberArr})" ).append("\n"); 
		query.append("#if($velocityCount == 1)" ).append("\n"); 
		query.append("('${key.trspSoOfcCtyCd}', ${key.trspSoSeq})" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", ('${key.trspSoOfcCtyCd}', ${key.trspSoSeq})" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("--/* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append("AND A.HJL_NO IS NULL" ).append("\n"); 
		query.append(") B" ).append("\n"); 

	}
}