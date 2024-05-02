/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOSearchPreVLVDListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.03.08 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOSearchPreVLVDListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOSearchPreVLVDListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("status",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOSearchPreVLVDListVORSQL").append("\n"); 
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
		query.append("SELECT DISTINCT SQ1.CNTR_NO AS CNTR_NO," ).append("\n"); 
		query.append("SQ1.CNTR_TPSZ_CD AS TS," ).append("\n"); 
		query.append("SQ1.CNMV_STS_CD AS STATUS," ).append("\n"); 
		query.append("SQ1.ORG_YD_CD AS ORG_YARD," ).append("\n"); 
		query.append("SQ1.EVENT_DT," ).append("\n"); 
		query.append("SQ1.EVENT_DT AS ORG_EVENT_DT," ).append("\n"); 
		query.append("SQ1.VVD," ).append("\n"); 
		query.append("(SELECT COUNT (*)" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC1" ).append("\n"); 
		query.append("WHERE BC1.CNTR_NO = SQ1.CNTR_NO" ).append("\n"); 
		query.append("AND BC1.CNMV_CYC_NO = SQ1.CYC_NO" ).append("\n"); 
		query.append("GROUP BY BC1.CNTR_NO, BC1.CNMV_CYC_NO) AS BKG_KNT," ).append("\n"); 
		query.append("BB.BKG_NO," ).append("\n"); 
		query.append("BB.BL_NO," ).append("\n"); 
		query.append("DECODE (BB.BKG_CGO_TP_CD, 'P', 'M', BB.BKG_CGO_TP_CD) AS FM," ).append("\n"); 
		query.append("SQ1.PREBKG_DT," ).append("\n"); 
		query.append("SQ1.OFC_CD AS OFFICE," ).append("\n"); 
		query.append("SQ1.USR_NM AS USER_NM," ).append("\n"); 
		query.append("SQ1.CNMV_RMK AS REMARK" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC2," ).append("\n"); 
		query.append("BKG_BOOKING BB," ).append("\n"); 
		query.append("(SELECT RSV.CNTR_NO," ).append("\n"); 
		query.append("MC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("RSV.CNMV_STS_CD," ).append("\n"); 
		query.append("RSV.ORG_YD_CD," ).append("\n"); 
		query.append("TO_CHAR (RSV.CNMV_EVNT_DT, 'YYYY-MM-DD HH24:MI') AS EVENT_DT," ).append("\n"); 
		query.append("RSV.CRNT_VSL_CD||RSV.CRNT_SKD_VOY_NO||RSV.CRNT_SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("TO_CHAR (RSV.UPD_LOCL_DT, 'YYYY-MM-DD HH24:MI') AS PREBKG_DT," ).append("\n"); 
		query.append("RSV.OFC_CD," ).append("\n"); 
		query.append("RSV.USR_NM," ).append("\n"); 
		query.append("RSV.CNMV_RMK," ).append("\n"); 
		query.append("(SELECT /*+ INDEX_desc(BC3 XAK1BKG_CONTAINER) */" ).append("\n"); 
		query.append("BC3.CNMV_CYC_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC3" ).append("\n"); 
		query.append("WHERE BC3.CNTR_NO = RSV.CNTR_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS CYC_NO," ).append("\n"); 
		query.append("(SELECT /*+ INDEX_desc(BC4 XAK1BKG_CONTAINER) */" ).append("\n"); 
		query.append("BC4.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC4" ).append("\n"); 
		query.append("WHERE BC4.CNTR_NO = RSV.CNTR_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1) AS BKG_NO" ).append("\n"); 
		query.append("FROM CTM_MVMT_RSV RSV," ).append("\n"); 
		query.append("MST_CONTAINER MC" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${p_date1} != '' && ${p_date2} != '')" ).append("\n"); 
		query.append("AND RSV.CNMV_EVNT_DT BETWEEN TO_DATE (@[p_date1], 'YYYY-MM-DD') AND TO_DATE (@[p_date2],'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${office} != '')" ).append("\n"); 
		query.append("AND RSV.OFC_CD = @[office]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${status} != '')" ).append("\n"); 
		query.append("AND RSV.CNMV_STS_CD = @[status]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${p_yard2} != '')" ).append("\n"); 
		query.append("AND RSV.ORG_YD_CD = @[p_yard1]||@[p_yard2]" ).append("\n"); 
		query.append("#elseif (${p_yard1} != '')" ).append("\n"); 
		query.append("AND RSV.ORG_YD_CD LIKE @[p_yard1]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND RSV.CRNT_VSL_CD||RSV.CRNT_SKD_VOY_NO||RSV.CRNT_SKD_DIR_CD LIKE @[vvd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND RSV.CNTR_NO = MC.CNTR_NO" ).append("\n"); 
		query.append("#if (${error} == 'Y')" ).append("\n"); 
		query.append("AND RSV.PRE_STS_FLG = 'Y'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND RSV.PRE_STS_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") SQ1" ).append("\n"); 
		query.append("WHERE BC2.CNTR_NO = SQ1.CNTR_NO" ).append("\n"); 
		query.append("#if (${fm} == 'M')" ).append("\n"); 
		query.append("AND BB.BKG_CGO_TP_CD IN ('P', 'M')" ).append("\n"); 
		query.append("#elseif (${fm} == 'F')" ).append("\n"); 
		query.append("AND BB.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND BC2.CNMV_CYC_NO = SQ1.CYC_NO" ).append("\n"); 
		query.append("AND BB.BKG_NO = SQ1.BKG_NO" ).append("\n"); 

	}
}