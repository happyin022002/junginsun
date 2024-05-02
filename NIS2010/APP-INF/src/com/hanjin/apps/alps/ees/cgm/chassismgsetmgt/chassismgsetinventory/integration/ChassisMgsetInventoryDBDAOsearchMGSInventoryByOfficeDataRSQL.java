/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.25
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.11.25 조재성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ChaeShung Cho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * chungpa 20090911 2079 start
	  * </pre>
	  */
	public ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_fm_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inq_to_dys",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.integration").append("\n"); 
		query.append("FileName : ChassisMgsetInventoryDBDAOsearchMGSInventoryByOfficeDataRSQL").append("\n"); 
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
		query.append("t1.STS_EVNT_OFC_CD" ).append("\n"); 
		query.append(", COUNT(*) AS EQ_TPSZ_CD_TOTAL" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN t1.EQ_TPSZ_CD = 'UMG' THEN 1 END),0) AS EQ_TPSZ_CD_UMG" ).append("\n"); 
		query.append(", NVL(SUM(CASE WHEN t1.EQ_TPSZ_CD = 'CLG' THEN 1 END),0) AS EQ_TPSZ_CD_CLG" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("DISTINCT A.EQ_NO AS EQ_NO" ).append("\n"); 
		query.append(",B.STS_EVNT_OFC_CD AS STS_EVNT_OFC_CD" ).append("\n"); 
		query.append(",A.EQ_TPSZ_CD AS EQ_TPSZ_CD" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A, CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND B.EQ_ASET_STS_CD = 'LSI'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inq_fm_dys} != '' && ${inq_to_dys} != '')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT BETWEEN TO_DATE(@[inq_fm_dys], 'YYYYMMDD') AND TO_DATE(@[inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${inq_fm_dys} != '' && ${inq_to_dys} == '')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT >= TO_DATE(@[inq_fm_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${inq_fm_dys} == '' && ${inq_to_dys} != '')" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT <= TO_DATE(@[inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crnt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND B.STS_EVNT_OFC_CD IN ($crnt_ofc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.STS_EVNT_DT =" ).append("\n"); 
		query.append("(	SELECT" ).append("\n"); 
		query.append("MAX(t2.STS_EVNT_DT)" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT t1, CGM_EQ_STS_HIS t2" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("t1.EQ_NO = t2.EQ_NO" ).append("\n"); 
		query.append("AND t1.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND t1.ACIAC_DIV_CD = 'A'" ).append("\n"); 
		query.append("AND t2.EQ_ASET_STS_CD = 'LSI'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${inq_fm_dys} != '' && ${inq_to_dys} != '')" ).append("\n"); 
		query.append("AND t2.STS_EVNT_DT BETWEEN TO_DATE(@[inq_fm_dys], 'YYYYMMDD') AND TO_DATE(@[inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${inq_fm_dys} != '' && ${inq_to_dys} == '')" ).append("\n"); 
		query.append("AND t2.STS_EVNT_DT >= TO_DATE(@[inq_fm_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#elseif (${inq_fm_dys} == '' && ${inq_to_dys} != '')" ).append("\n"); 
		query.append("AND t2.STS_EVNT_DT <= TO_DATE(@[inq_to_dys], 'YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${crnt_ofc_cd} != '')" ).append("\n"); 
		query.append("AND t2.STS_EVNT_OFC_CD IN ($crnt_ofc_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND t1.EQ_NO = A.EQ_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") t1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY t1.STS_EVNT_OFC_CD" ).append("\n"); 
		query.append("ORDER BY t1.STS_EVNT_OFC_CD" ).append("\n"); 

	}
}