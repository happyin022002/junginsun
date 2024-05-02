/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByStandardTariffDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.27
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.04.27 김완규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByStandardTariffDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Verify - [EES_MNR_0190] 수정된 컬럼의 값들이 Standard Tariff 의 데이터와 일치하는지 Verify 한다.
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByStandardTariffDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("std_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByStandardTariffDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DAT_VRFY A" ).append("\n"); 
		query.append("SET A.INP_MSG4 = 'SU'" ).append("\n"); 
		query.append("WHERE A.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND A.INP_MSG17||A.INP_MSG1||A.INP_MSG2||A.INP_MSG6||A.INP_MSG7||A.INP_MSG10||A.INP_MSG11||A.INP_MSG12||A.INP_MSG13||A.INP_MSG8||A.INP_MSG9||A.INP_MSG14" ).append("\n"); 
		query.append("NOT IN (SELECT B.COST_GRP_CD||B.EQ_CMPO_CD||B.EQ_RPR_CD||B.TRF_DIV_CD||B.DTL_DESC||B.MNR_RNG_TP_CD||B.VOL_TP_CD||B.RPR_QTY||B.RPR_SZ_NO||B.FM_RNG_SZ_NO||B.TO_RNG_SZ_NO||CASE WHEN B.RPR_LBR_HRS < 1 AND B.RPR_LBR_HRS > 0 THEN '0'||TO_CHAR(B.RPR_LBR_HRS) ELSE TO_CHAR(B.RPR_LBR_HRS) END" ).append("\n"); 
		query.append("FROM MNR_RPR_TRF_DTL B" ).append("\n"); 
		query.append("WHERE B.TRF_NO = @[std_trf_no])" ).append("\n"); 

	}
}