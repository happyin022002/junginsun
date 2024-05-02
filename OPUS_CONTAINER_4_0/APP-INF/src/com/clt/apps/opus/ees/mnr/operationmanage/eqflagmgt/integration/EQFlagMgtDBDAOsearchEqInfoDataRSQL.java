/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtDBDAOsearchEqInfoDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.11.10 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOsearchEqInfoDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEqInfoData
	  * </pre>
	  */
	public EQFlagMgtDBDAOsearchEqInfoDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOsearchEqInfoDataRSQL").append("\n"); 
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
		query.append("SELECT A.EQ_TYPE" ).append("\n"); 
		query.append(", A.EQ_NO" ).append("\n"); 
		query.append(", A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", NVL(A.DMG_FLAG,'N') AS DMG_FLAG" ).append("\n"); 
		query.append(", A.MANU_DT" ).append("\n"); 
		query.append(", A.LESSOR_NM" ).append("\n"); 
		query.append(", A.LSTM_CD" ).append("\n"); 
		query.append(", A.DSP_FLAG" ).append("\n"); 
		query.append(", A.OFF_HIRE" ).append("\n"); 
		query.append(", A.IMM_EXT" ).append("\n"); 
		query.append(", A.MVMT_CD" ).append("\n"); 
		query.append(", A.MVMT_DT" ).append("\n"); 
		query.append(", A.RPR_TYPE" ).append("\n"); 
		query.append(", A.STATUS" ).append("\n"); 
		query.append(", A.COST" ).append("\n"); 
		query.append(", A.DV_CUR" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_CAL_DV_FNC(A.EQ_TYPE, A.EQ_NO,TO_CHAR(sysdate,'yyyymmdd'))  DV_VALUE" ).append("\n"); 
		query.append(", A.CRNT_YD_CD" ).append("\n"); 
		query.append(", A.HNGR_FLG_YD" ).append("\n"); 
		query.append(", A.HNGR_RCK_CD" ).append("\n"); 
		query.append(", A.BAR_ATCH_KNT" ).append("\n"); 
		query.append(", A.BAR_TP_CD" ).append("\n"); 
		query.append(", A.HNGR_FLG_DT" ).append("\n"); 
		query.append(", A.FLG_RMK" ).append("\n"); 
		query.append(", A.MTRL_CD" ).append("\n"); 
		query.append(", A.MTRL_NM" ).append("\n"); 
		query.append(", A.MKR_NM" ).append("\n"); 
		query.append(", A.MDL_NM" ).append("\n"); 
		query.append("FROM MNR_EQ_STS_V A" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 

	}
}