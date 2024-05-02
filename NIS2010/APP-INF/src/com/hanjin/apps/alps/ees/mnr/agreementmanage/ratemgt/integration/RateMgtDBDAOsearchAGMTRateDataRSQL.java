/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtDBDAOsearchAGMTRateDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.10.28 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 함형석
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOsearchAGMTRateDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAGMTRateData
	  * </pre>
	  */
	public RateMgtDBDAOsearchAGMTRateDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_eq_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_dis_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration").append("\n"); 
		query.append("FileName : RateMgtDBDAOsearchAGMTRateDataRSQL").append("\n"); 
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
		query.append("C.AGMT_OFC_CTY_CD," ).append("\n"); 
		query.append("C.AGMT_SEQ," ).append("\n"); 
		query.append("C.AGMT_VER_NO," ).append("\n"); 
		query.append("C.COST_CD," ).append("\n"); 
		query.append("C.COST_DTL_CD," ).append("\n"); 
		query.append("C.MNR_RT_TP_CD," ).append("\n"); 
		query.append("C.RPR_QTY," ).append("\n"); 
		query.append("C.AGMT_RT_AMT," ).append("\n"); 
		query.append("C.CRE_USR_ID," ).append("\n"); 
		query.append("C.CRE_DT," ).append("\n"); 
		query.append("C.UPD_USR_ID," ).append("\n"); 
		query.append("C.UPD_DT" ).append("\n"); 
		query.append("FROM MNR_AGMT_RT C" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("C.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd] AND" ).append("\n"); 
		query.append("C.AGMT_SEQ = @[agmt_seq] AND" ).append("\n"); 
		query.append("C.AGMT_VER_NO = @[agmt_ver_no] AND" ).append("\n"); 
		query.append("C.COST_CD IN (" ).append("\n"); 
		query.append("SELECT G.MNR_CD_ID" ).append("\n"); 
		query.append("FROM MNR_GEN_CD G" ).append("\n"); 
		query.append("WHERE G.PRNT_CD_ID = @[agmt_eq_type] || 'G'" ).append("\n"); 
		query.append("AND SUBSTRB(G.MNR_CD_ID, LENGTH(G.MNR_CD_ID) - 1, LENGTH(G.MNR_CD_ID)) = @[agmt_dis_type]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}