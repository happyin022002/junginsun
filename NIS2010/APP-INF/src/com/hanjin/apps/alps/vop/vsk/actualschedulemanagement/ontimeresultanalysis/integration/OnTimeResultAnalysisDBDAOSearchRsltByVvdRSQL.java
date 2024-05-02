/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnTimeResultAnalysisDBDAOSearchRsltByVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.10.13 유혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Hyuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OnTimeResultAnalysisDBDAOSearchRsltByVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD에 대해서 VSK_VSL_SKD_RSLT 테이블을 조회한다.
	  * </pre>
	  */
	public OnTimeResultAnalysisDBDAOSearchRsltByVvdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.integration").append("\n"); 
		query.append("FileName : OnTimeResultAnalysisDBDAOSearchRsltByVvdRSQL").append("\n"); 
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
		query.append("T2.VSL_SLAN_CD" ).append("\n"); 
		query.append(",	T1.VSL_CD" ).append("\n"); 
		query.append(",	T1.SKD_VOY_NO" ).append("\n"); 
		query.append(",	T1.SUB_TRD_DIR_CD" ).append("\n"); 
		query.append(",	T1.VPS_PORT_CD" ).append("\n"); 
		query.append(",	T1.CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	T1.CLPT_SEQ" ).append("\n"); 
		query.append(",	T1.SKD_DIR_CD" ).append("\n"); 
		query.append(",	T1.ACT_INP_YRMON" ).append("\n"); 
		query.append(",	T1.SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",	TO_CHAR(T1.PF_ETB_DT, 'YYYY-MM-DD HH24:MI') PF_ETB_DT" ).append("\n"); 
		query.append(",	TO_CHAR(T1.PF_ETD_DT, 'YYYY-MM-DD HH24:MI') PF_ETD_DT" ).append("\n"); 
		query.append(",	TO_CHAR(T1.ACT_BRTH_DT, 'YYYY-MM-DD HH24:MI') ACT_BRTH_DT" ).append("\n"); 
		query.append(",	TO_CHAR(T1.ACT_DEP_DT, 'YYYY-MM-DD HH24:MI') ACT_DEP_DT" ).append("\n"); 
		query.append(",	T1.ARR_DLAY_HRS1" ).append("\n"); 
		query.append(",	T1.ARR_DLAY_HRS2" ).append("\n"); 
		query.append(",	T1.ARR_DLAY_RSN_CD1" ).append("\n"); 
		query.append(",	T1.ARR_DLAY_RSN_CD2" ).append("\n"); 
		query.append(",	T1.ARR_RMK1" ).append("\n"); 
		query.append(",	T1.ARR_RMK2" ).append("\n"); 
		query.append(",	T1.DEP_DLAY_HRS1" ).append("\n"); 
		query.append(",	T1.DEP_DLAY_HRS2" ).append("\n"); 
		query.append(",	T1.DEP_DLAY_RSN_CD1" ).append("\n"); 
		query.append(",	T1.DEP_DLAY_RSN_CD2" ).append("\n"); 
		query.append(",	T1.DEP_RMK1" ).append("\n"); 
		query.append(",	T1.DEP_RMK2" ).append("\n"); 
		query.append(",	T1.INCL_BRTH_DLAY_HRS" ).append("\n"); 
		query.append(",	T1.INCL_DEP_DLAY_HRS" ).append("\n"); 
		query.append(",	T1.XCLD_BRTH_DLAY_HRS" ).append("\n"); 
		query.append(",	T1.XCLD_DEP_DLAY_HRS" ).append("\n"); 
		query.append(",	T1.VSKD_RSLT_XCLD_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD_RSLT T1, VSK_VSL_SKD T2" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND T1.VSL_CD = T2.VSL_CD" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND T1.SKD_DIR_CD = T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND T1.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND T1.SKD_VOY_NO = @[voy_no]" ).append("\n"); 
		query.append("AND T1.SUB_TRD_DIR_CD = @[dir_cd]" ).append("\n"); 
		query.append("ORDER BY T1.CLPT_SEQ" ).append("\n"); 

	}
}