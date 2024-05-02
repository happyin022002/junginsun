/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TariffRuleDBDAOTariffRuleExperationDateVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.20
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.04.20 이행지
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

public class TariffRuleDBDAOTariffRuleExperationDateVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History-----------------------------------
	  * 2011.04.19 이행지 [CHM-201110201-01] Tariff Rule 관련 Status 변경 관리자 기능 추가 요청
	  *                                                          - Experation Data 체크
	  * </pre>
	  */
	public TariffRuleDBDAOTariffRuleExperationDateVORSQL(){
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
		query.append("FileName : TariffRuleDBDAOTariffRuleExperationDateVORSQL").append("\n"); 
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
		query.append("SELECT  B.EFF_DT-A.EXP_DT AS DIFF" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  EFF_DT,EXP_DT,PUB_DT" ).append("\n"); 
		query.append("          FROM  PRI_TRF_RULE" ).append("\n"); 
		query.append("         WHERE TRF_PFX_CD	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("           AND TRF_NO		= @[trf_no]" ).append("\n"); 
		query.append("           AND TRF_RULE_NO	= @[trf_rule_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ     = @[amdt_seq]-1" ).append("\n"); 
		query.append("        ) A," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("        SELECT  EFF_DT,EXP_DT,PUB_DT" ).append("\n"); 
		query.append("          FROM  PRI_TRF_RULE" ).append("\n"); 
		query.append("         WHERE TRF_PFX_CD	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("           AND TRF_NO		= @[trf_no]" ).append("\n"); 
		query.append("           AND TRF_RULE_NO	= @[trf_rule_no]" ).append("\n"); 
		query.append("           AND AMDT_SEQ     = @[amdt_seq]" ).append("\n"); 
		query.append("        ) B" ).append("\n"); 

	}
}