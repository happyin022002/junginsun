/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReeferSparePartMgtDBDAOsearchRFSparePartInventoryListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReeferSparePartMgtDBDAOsearchRFSparePartInventoryListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회
	  * </pre>
	  */
	public ReeferSparePartMgtDBDAOsearchRFSparePartInventoryListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tocal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromcal",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.integration").append("\n"); 
		query.append("FileName : ReeferSparePartMgtDBDAOsearchRFSparePartInventoryListDataRSQL").append("\n"); 
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
		query.append("A.VSL_CD" ).append("\n"); 
		query.append("#if (${vsl_cd} =='')" ).append("\n"); 
		query.append(",C.VSL_ENG_NM" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",A.LANE_CD" ).append("\n"); 
		query.append(",A.SPR_TP_CD" ).append("\n"); 
		query.append(",TO_CHAR(A.SPR_SPL_DT, 'yyyy-mm-dd') SPR_SPL_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.DCHG_DT, 'yyyy-mm-dd') DCHG_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.SPR_CHK_DT, 'yyyy-mm-dd') SPR_CHK_DT" ).append("\n"); 
		query.append(",A.INVT_RMK" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT, 'yyyy-mm-dd') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') UPD_DT" ).append("\n"); 
		query.append("FROM MNR_RF_SPR_PRT_INVT A," ).append("\n"); 
		query.append("#if (${vsl_cd} =='')" ).append("\n"); 
		query.append("(SELECT /*+ INDEX_DESC(A XPKVSK_VSL_SKD)*/" ).append("\n"); 
		query.append("A.VSL_CD,  A.VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DISTINCT  VSL_CD,  VSL_SLAN_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} !='')" ).append("\n"); 
		query.append("WHERE VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} !='')" ).append("\n"); 
		query.append("AND A.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") B," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("MDM_VSL_CNTR C" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${vsl_cd} =='')" ).append("\n"); 
		query.append("AND A.VSL_CD=B.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.VSL_CD=C.VSL_CD(+)" ).append("\n"); 
		query.append("AND A.LANE_CD=B.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} !='')" ).append("\n"); 
		query.append("AND A.LANE_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${date_gubun} == '0')" ).append("\n"); 
		query.append("AND A.SPR_SPL_DT BETWEEN TO_DATE(@[fromcal], 'YYYY-MM-DD') AND TO_DATE(@[tocal] || ' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#elseif (${date_gubun} == '1')" ).append("\n"); 
		query.append("AND A.DCHG_DT BETWEEN TO_DATE(@[fromcal], 'YYYY-MM-DD') AND TO_DATE(@[tocal] || ' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#elseif (${date_gubun} == '2')" ).append("\n"); 
		query.append("AND A.SPR_CHK_DT BETWEEN TO_DATE(@[fromcal], 'YYYY-MM-DD') AND TO_DATE(@[tocal] || ' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spr_tp_cd} != '')" ).append("\n"); 
		query.append("AND A.SPR_TP_CD = @[spr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.VSL_CD" ).append("\n"); 

	}
}