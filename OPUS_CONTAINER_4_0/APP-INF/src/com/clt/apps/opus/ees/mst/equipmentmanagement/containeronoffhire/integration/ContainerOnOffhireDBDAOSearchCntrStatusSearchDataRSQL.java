/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerOnOffhireDBDAOSearchCntrStatusSearchDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.08 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerOnOffhireDBDAOSearchCntrStatusSearchDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Status Agmt No 변경에 따른 화면에 데이타 set
	  * </pre>
	  */
	public ContainerOnOffhireDBDAOSearchCntrStatusSearchDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("off_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("on_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.integration ").append("\n"); 
		query.append("FileName : ContainerOnOffhireDBDAOSearchCntrStatusSearchDataRSQL").append("\n"); 
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
		query.append("WITH PARAM AS ( SELECT  @[cntr_no]   AS CNTR_NO" ).append("\n"); 
		query.append("                     ,  'HHO'         AS AGMT_CTY_CD" ).append("\n"); 
		query.append("                     , @[agmt_seq] AS AGMT_SEQ" ).append("\n"); 
		query.append("                     , @[on_yd_cd] AS ON_YD_CD" ).append("\n"); 
		query.append("                     , @[off_yd_cd]  AS OFF_YD_CD " ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("SELECT -- Only LSI, MUO, SBO --> Free Days Column Update" ).append("\n"); 
		query.append("          LA.LSE_FREE_DYS AS RNTL_CHG_FREE_DYS " ).append("\n"); 
		query.append("          -- Only LSI, MUO, SBO --> Handle On/Off Charge Column Update" ).append("\n"); 
		query.append("       ,  MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC (LA.AGMT_CTY_CD, LA.AGMT_SEQ, 'LON', MC.CNTR_TPSZ_CD, P.ON_YD_CD) AS LFT_ON_AMT " ).append("\n"); 
		query.append("         -- Only LSO, MUI, SBI --> Handle On/Off Charge Column Update" ).append("\n"); 
		query.append("       ,  MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC (LA.AGMT_CTY_CD, LA.AGMT_SEQ, 'LOF', MC.CNTR_TPSZ_CD, P.OFF_YD_CD) AS LFT_OFF_AMT" ).append("\n"); 
		query.append("          -- Handle On/Off Charge Columndp 값이 있을 경우 앞 Currency Code Update" ).append("\n"); 
		query.append("       ,  LA.CURR_CD AS CURR_CD" ).append("\n"); 
		query.append("          -- Only LSO     --> DOC Charge Column Update" ).append("\n"); 
		query.append("       ,  MST_COMMON_PKG.MST_LSE_AGMT_RT_GET_FNC (LA.AGMT_CTY_CD, LA.AGMT_SEQ, 'DOC', MC.CNTR_TPSZ_CD, P.OFF_YD_CD) AS CNTR_DRFF_AMT" ).append("\n"); 
		query.append("       , LA.LSTM_CD AS LSTM_CD" ).append("\n"); 
		query.append("FROM LSE_AGREEMENT LA" ).append("\n"); 
		query.append("	, MST_CONTAINER MC  " ).append("\n"); 
		query.append(" 	, PARAM P" ).append("\n"); 
		query.append("WHERE  MC.CNTR_NO  = P.CNTR_NO" ).append("\n"); 
		query.append("AND LA.AGMT_CTY_CD = P.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND LA.AGMT_SEQ     = P.AGMT_SEQ" ).append("\n"); 
		query.append("AND ROWNUM          = 1" ).append("\n"); 

	}
}