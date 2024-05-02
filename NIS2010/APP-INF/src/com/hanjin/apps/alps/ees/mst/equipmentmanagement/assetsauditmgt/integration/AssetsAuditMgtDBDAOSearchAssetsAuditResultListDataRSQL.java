/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AssetsAuditMgtDBDAOSearchAssetsAuditResultListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.29
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.03.29 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Ho Sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AssetsAuditMgtDBDAOSearchAssetsAuditResultListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchAssetsAuditResultListData
	  * </pre>
	  */
	public AssetsAuditMgtDBDAOSearchAssetsAuditResultListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yr_mon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rslt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mst.equipmentmanagement.assetsauditmgt.integration").append("\n"); 
		query.append("FileName : AssetsAuditMgtDBDAOSearchAssetsAuditResultListDataRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("   A.EQ_NO," ).append("\n"); 
		query.append("#if (${eq_type} == 'U')" ).append("\n"); 
		query.append("   B.CNTR_TPSZ_CD EQ_TPSZ_CD," ).append("\n"); 
		query.append("   B.LSTM_CD," ).append("\n"); 
		query.append("   B.CNTR_STS_CD," ).append("\n"); 
		query.append("   B.CNMV_STS_CD ," ).append("\n"); 
		query.append("#else   " ).append("\n"); 
		query.append("   B.EQ_TPSZ_CD," ).append("\n"); 
		query.append("   B.AGMT_LSTM_CD LSTM_CD," ).append("\n"); 
		query.append("   (SELECT C.EQ_ASET_STS_CD " ).append("\n"); 
		query.append("    FROM CGM_EQ_STS_HIS C " ).append("\n"); 
		query.append("    WHERE 1 = 1" ).append("\n"); 
		query.append("    AND C.EQ_NO = B.EQ_NO" ).append("\n"); 
		query.append("    AND C.EQ_STS_SEQ = B.EQ_STS_SEQ" ).append("\n"); 
		query.append("    AND C.EQ_KND_CD = @[eq_type]) CNTR_STS_CD," ).append("\n"); 
		query.append("   B.CHSS_MVMT_STS_CD CNMV_STS_CD," ).append("\n"); 
		query.append("#end   " ).append("\n"); 
		query.append("   B.CRNT_YD_CD," ).append("\n"); 
		query.append("#if (${eq_type} == 'U')        " ).append("\n"); 
		query.append("   TO_CHAR(B.CNMV_DT, 'YYYY-MM-DD') CNMV_DT," ).append("\n"); 
		query.append("#else      " ).append("\n"); 
		query.append("   TO_CHAR(B.CHSS_MVMT_DT, 'YYYY-MM-DD') CNMV_DT," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   A.DIFF_RMK," ).append("\n"); 
		query.append("   A.EQ_FA_AUD_RSLT_CD" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("   MST_EQ_ASET_AUD_RSLT A," ).append("\n"); 
		query.append("#if (${eq_type} == 'U')   " ).append("\n"); 
		query.append("   MST_CONTAINER B" ).append("\n"); 
		query.append("#else   " ).append("\n"); 
		query.append("   CGM_EQUIPMENT B" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND  A.JB_EXE_YRMON = REPLACE(NVL(@[yr_mon],'0'),'-','')" ).append("\n"); 
		query.append("AND  A.VER_NO       = @[ver_no]" ).append("\n"); 
		query.append("AND  A.EQ_KND_CD    = @[eq_type]" ).append("\n"); 
		query.append("AND  A.EQ_FA_AUD_RSLT_CD = @[rslt_cd]" ).append("\n"); 
		query.append("#if (${eq_type} == 'U')   " ).append("\n"); 
		query.append("#if (${rslt_cd} == 'F') " ).append("\n"); 
		query.append("AND  A.EQ_NO        = SUBSTR(B.CNTR_NO(+),0,10)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND  A.EQ_NO        = B.CNTR_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#else   " ).append("\n"); 
		query.append("AND  A.EQ_NO        = B.EQ_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}