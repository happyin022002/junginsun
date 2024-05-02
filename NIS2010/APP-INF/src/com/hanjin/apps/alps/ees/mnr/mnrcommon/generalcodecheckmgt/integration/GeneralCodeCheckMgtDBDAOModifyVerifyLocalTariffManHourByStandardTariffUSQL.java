/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAOModifyVerifyLocalTariffManHourByStandardTariffUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.25
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralCodeCheckMgtDBDAOModifyVerifyLocalTariffManHourByStandardTariffUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Local Tariff의 Man-Hour 값에 대한 Standard Tariff와의 비교
	  * 단, IMP_MSG3의 값이 W이면 Warning, E이면 Error 이며 Warning의 경우 다음 단계 진행 가능
	  * </pre>
	  */
	public GeneralCodeCheckMgtDBDAOModifyVerifyLocalTariffManHourByStandardTariffUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("std_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tmp_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.integration").append("\n"); 
		query.append("FileName : GeneralCodeCheckMgtDBDAOModifyVerifyLocalTariffManHourByStandardTariffUSQL").append("\n"); 
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
		query.append("UPDATE   MNR_DAT_VRFY L" ).append("\n"); 
		query.append("SET      L.INP_MSG3 = 'W'" ).append("\n"); 
		query.append("       , L.INP_MSG4 = 'ME'" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("AND      L.TMP_SEQ = @[tmp_seq]" ).append("\n"); 
		query.append("AND      L.INP_MSG4 = 'SU'" ).append("\n"); 
		query.append("AND      L.INP_MSG17||L.INP_MSG1||L.INP_MSG2||L.INP_MSG6||L.INP_MSG7||L.INP_MSG10||L.INP_MSG11||L.INP_MSG12||L.INP_MSG13||L.INP_MSG8||L.INP_MSG9 IN" ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("           SELECT   S.COST_GRP_CD||S.EQ_CMPO_CD||S.EQ_RPR_CD||S.TRF_DIV_CD||S.DTL_DESC||S.MNR_RNG_TP_CD||S.VOL_TP_CD||S.RPR_QTY||S.RPR_SZ_NO||S.FM_RNG_SZ_NO||S.TO_RNG_SZ_NO" ).append("\n"); 
		query.append("           FROM     MNR_RPR_TRF_DTL S" ).append("\n"); 
		query.append("           WHERE    1 = 1" ).append("\n"); 
		query.append("           AND      S.TRF_NO = @[std_trf_no]" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}