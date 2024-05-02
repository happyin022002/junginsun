/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TariffRuleDBDAOTariffRulePublishCancelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.05.17 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffRuleDBDAOTariffRulePublishCancelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History------------------------
	  * 2011.05.16 이행지 [CHM-201110773-01] [PRI] Tariff Rule - Publish Cancel 기능 보완
	  *                                                         - 로딩시 조회해오는 데이터
	  * </pre>
	  */
	public TariffRuleDBDAOTariffRulePublishCancelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_pfx_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_rule_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.tariff.tariffrule.integration").append("\n"); 
		query.append("FileName : TariffRuleDBDAOTariffRulePublishCancelRSQL").append("\n"); 
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
		query.append("SELECT  TRF_PFX_CD, TRF_NO, TRF_RULE_NO, AMDT_SEQ" ).append("\n"); 
		query.append("	,	TO_CHAR(EFF_DT,'YYYY-MM-DD') EFF_DT" ).append("\n"); 
		query.append("	,	TO_CHAR(EXP_DT,'YYYY-MM-DD') EXP_DT" ).append("\n"); 
		query.append("	,   TRF_RULE_STS_CD" ).append("\n"); 
		query.append("	,	TO_CHAR(UPD_DT,'YYYYMMDD-HH24MISS') UPD_DT" ).append("\n"); 
		query.append("  FROM  PRI_TRF_RULE" ).append("\n"); 
		query.append(" WHERE  TRF_PFX_CD  = @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND  TRF_NO      = @[trf_no]" ).append("\n"); 
		query.append("   AND  TRF_RULE_NO = @[trf_rule_no]" ).append("\n"); 
		query.append("   AND  AMDT_SEQ BETWEEN @[amdt_seq]-1 AND @[amdt_seq]" ).append("\n"); 

	}
}