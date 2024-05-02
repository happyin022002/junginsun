/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementFinderDBDAOSearchEmptyBookingListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.05 김상수
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

public class ContainerMovementFinderDBDAOSearchEmptyBookingListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementFinderDBDAOSearchEmptyBookingListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_yard2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lcc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_date1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.integration").append("\n"); 
		query.append("FileName : ContainerMovementFinderDBDAOSearchEmptyBookingListVORSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX CTM_MOVEMENT XAK4CTM_MOVEMENT */" ).append("\n"); 
		query.append("D.CALL_SGN_NO," ).append("\n"); 
		query.append("TO_CHAR (D.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS CNMV_EVNT_DT," ).append("\n"); 
		query.append("D.CNTR_NO," ).append("\n"); 
		query.append("D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("D.LLOYD_NO," ).append("\n"); 
		query.append("D.MTY_REPO_VL_RMK," ).append("\n"); 
		query.append("D.MVMT_STS_CD," ).append("\n"); 
		query.append("D.ORG_YD_CD," ).append("\n"); 
		query.append("E.BKG_POD_CD," ).append("\n"); 
		query.append("D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD AS VVD_CD," ).append("\n"); 
		query.append("D.CRNT_VSL_CD||D.CRNT_SKD_VOY_NO||D.CRNT_SKD_DIR_CD AS CNTR_ID," ).append("\n"); 
		query.append("D.CNMV_YR," ).append("\n"); 
		query.append("D.CNMV_ID_NO," ).append("\n"); 
		query.append("D.SYS_AREA_GRP_ID AS CNTR_SVR_ID," ).append("\n"); 
		query.append("'X' AS LST_FLG," ).append("\n"); 
		query.append("'P' AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("D.CNMV_SEQ," ).append("\n"); 
		query.append("D.CNMV_CO_CD," ).append("\n"); 
		query.append("D.MVMT_EDI_MSG_TP_ID," ).append("\n"); 
		query.append("D.MVMT_CRE_TP_CD," ).append("\n"); 
		query.append("D.CNTR_XCH_CD," ).append("\n"); 
		query.append("D.MGST_NO," ).append("\n"); 
		query.append("D.CHSS_NO," ).append("\n"); 
		query.append("D.INP_YD_CD," ).append("\n"); 
		query.append("D.DEST_YD_CD," ).append("\n"); 
		query.append("D.CNMV_SPLIT_NO," ).append("\n"); 
		query.append("D.PKUP_NO," ).append("\n"); 
		query.append("D.WBL_NO" ).append("\n"); 
		query.append("FROM MDM_EQ_ORZ_CHT A, MDM_LOCATION B, COM_SYS_AREA_GRP_ID C, CTM_MOVEMENT D, CTM_MVMT_EDI_MSG E" ).append("\n"); 
		query.append("WHERE A.LCC_CD = @[lcc_cd]" ).append("\n"); 
		query.append("AND A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND B.LOC_CD = SUBSTR (D.ORG_YD_CD, 0, 5)" ).append("\n"); 
		query.append("AND C.CNT_CD = SUBSTR (D.ORG_YD_CD, 0, 2)" ).append("\n"); 
		query.append("AND D.SYS_AREA_GRP_ID = C.SYS_AREA_GRP_ID" ).append("\n"); 
		query.append("AND D.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("AND D.PRE_STS_FLG = 'Y'" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("AND D.ORG_YD_CD = @[p_yard1]|| @[p_yard2]" ).append("\n"); 
		query.append("#elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("AND D.ORG_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lloyd_no} != '')" ).append("\n"); 
		query.append("AND (UPPER (D.CALL_SGN_NO) LIKE '%'||UPPER (@[lloyd_no])||'%' OR UPPER (D.LLOYD_NO) LIKE '%'||UPPER (@[lloyd_no])||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND D.MVMT_EDI_TP_CD = E.MVMT_EDI_TP_CD" ).append("\n"); 
		query.append("AND D.MVMT_EDI_MSG_TP_ID = E.MVMT_EDI_MSG_TP_ID" ).append("\n"); 
		query.append("AND D.MVMT_EDI_MSG_AREA_CD = E.MVMT_EDI_MSG_AREA_CD" ).append("\n"); 
		query.append("AND D.MVMT_EDI_MSG_YRMONDY = E.MVMT_EDI_MSG_YRMONDY" ).append("\n"); 
		query.append("AND D.MVMT_EDI_MSG_SEQ = E.MVMT_EDI_MSG_SEQ" ).append("\n"); 

	}
}