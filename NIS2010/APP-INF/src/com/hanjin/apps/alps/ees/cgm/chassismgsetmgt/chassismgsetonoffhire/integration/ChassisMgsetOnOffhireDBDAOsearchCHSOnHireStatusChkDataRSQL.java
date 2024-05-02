/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMgsetOnOffhireDBDAOsearchCHSOnHireStatusChkDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2010.03.24 조재성
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

public class ChassisMgsetOnOffhireDBDAOsearchCHSOnHireStatusChkDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ChassisMgsetOnOffhireDBDAOsearchCHSOnHireStatusChkDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration").append("\n"); 
		query.append("FileName : ChassisMgsetOnOffhireDBDAOsearchCHSOnHireStatusChkDataRSQL").append("\n"); 
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
		query.append("SELECT A.ONH_OFC_CD," ).append("\n"); 
		query.append("TO_CHAR(A.ONH_DT, 'yyyy-MM-dd') AS ONH_DT," ).append("\n"); 
		query.append("A.ONH_YD_CD," ).append("\n"); 
		query.append("B.AGMT_OFC_CTY_CD||B.AGMT_SEQ AS AGREEMENT_NO," ).append("\n"); 
		query.append("A.AGMT_VER_NO," ).append("\n"); 
		query.append("B.AGMT_REF_NO," ).append("\n"); 
		query.append("B.AGMT_LSTM_CD," ).append("\n"); 
		query.append("B.VNDR_SEQ," ).append("\n"); 
		query.append("(SELECT VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR C" ).append("\n"); 
		query.append("WHERE C.VNDR_SEQ = B.VNDR_SEQ) AS VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("A.EQ_NO," ).append("\n"); 
		query.append("A.EQ_TPSZ_CD," ).append("\n"); 
		query.append("TO_CHAR(A.MFT_DT, 'yyyy-MM-dd') AS MFT_DT," ).append("\n"); 
		query.append("A.CHSS_TARE_WGT," ).append("\n"); 
		query.append("A.CHSS_RGST_STE_CD," ).append("\n"); 
		query.append("A.CHSS_RGST_YR," ).append("\n"); 
		query.append("TO_CHAR(A.CHSS_RGST_EXP_DT, 'yyyy-MM-dd') AS CHSS_RGST_EXP_DT," ).append("\n"); 
		query.append("A.CHSS_RGST_LIC_NO," ).append("\n"); 
		query.append("A.CHSS_VEH_ID_NO," ).append("\n"); 
		query.append("A.CHSS_TIT_NO," ).append("\n"); 
		query.append("A.CHSS_ALS_NO," ).append("\n"); 
		query.append("TO_CHAR(A.CRE_DT, 'yyyy-MM-dd') AS CRE_DT," ).append("\n"); 
		query.append("A.CRE_USR_ID" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, CGM_AGREEMENT B" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = B.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND A.AGMT_SEQ = B.AGMT_SEQ" ).append("\n"); 
		query.append("AND A.AGMT_VER_NO = B.AGMT_VER_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = B.EQ_KND_CD" ).append("\n"); 
		query.append("AND A.EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND B.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND B.DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY EQ_NO" ).append("\n"); 

	}
}