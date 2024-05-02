/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchCHSEquipmentDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.02.18 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetOnOffhireDBDAOsearchCHSEquipmentDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchCHSEquipmentDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no_fm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_rgst_lic_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no_tmp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_veh_id_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchCHSEquipmentDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_NO," ).append("\n"); 
		query.append("A.EQ_KND_CD," ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("A.AGMT_SEQ," ).append("\n"); 
		query.append("A.AGMT_VER_NO," ).append("\n"); 
		query.append("A.CHSS_RGST_LIC_NO," ).append("\n"); 
		query.append("A.CHSS_VEH_ID_NO," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("TO_CHAR (A.MFT_DT, 'yyyy-mm-dd') AS MFT_DT," ).append("\n"); 
		query.append("A.CHSS_TARE_WGT," ).append("\n"); 
		query.append("A.CHSS_RGST_STE_CD," ).append("\n"); 
		query.append("A.CHSS_RGST_YR," ).append("\n"); 
		query.append("A.CHSS_RGST_PRD_CD," ).append("\n"); 
		query.append("TO_CHAR (A.CHSS_RGST_EXP_DT, 'yyyy-mm-dd') AS CHSS_RGST_EXP_DT," ).append("\n"); 
		query.append("A.CHSS_RGST_LIC_NO," ).append("\n"); 
		query.append("A.CHSS_TIT_NO," ).append("\n"); 
		query.append("A.CHSS_ALS_NO," ).append("\n"); 
		query.append("A.N2ND_CHSS_ALS_NO," ).append("\n"); 
		query.append("A.ONH_YD_CD," ).append("\n"); 
		query.append("A.ONH_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(A.ONH_DT, 'yyyy-mm-dd') AS CRE_DT," ).append("\n"); 
		query.append("A.CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(A.CHSS_RGST_UPD_DT, 'yyyy-mm-dd') AS CHSS_RGST_UPD_DT," ).append("\n"); 
		query.append("A.CHSS_RGST_UPD_ID," ).append("\n"); 
		query.append("TO_CHAR(A.UPD_DT, 'yyyy-mm-dd') AS UPD_DT," ).append("\n"); 
		query.append("A.UPD_USR_ID," ).append("\n"); 
		query.append("'' AS EQ_NO_TMP" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A" ).append("\n"); 
		query.append("WHERE A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("#if (${eq_no_tmp} != '')" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no_tmp]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${eq_no_fm} != '' && ${eq_no_to} != '')" ).append("\n"); 
		query.append("AND A.EQ_NO BETWEEN @[eq_no_fm] AND SUBSTR(@[eq_no_fm], 1, 4)||@[eq_no_to]" ).append("\n"); 
		query.append("#elseif (${eq_no_fm} != '' && ${eq_no_to} == '')" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no_fm]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chss_rgst_lic_no} != '')" ).append("\n"); 
		query.append("AND A.CHSS_RGST_LIC_NO like '%%'||@[chss_rgst_lic_no]||'%%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chss_veh_id_no} != '')" ).append("\n"); 
		query.append("AND A.CHSS_VEH_ID_NO like '%%'||@[chss_veh_id_no]||'%%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${chss_rgst_exp_dt} != '')" ).append("\n"); 
		query.append("AND A.CHSS_RGST_EXP_DT <= TO_DATE(@[chss_rgst_exp_dt]||'1231','YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}