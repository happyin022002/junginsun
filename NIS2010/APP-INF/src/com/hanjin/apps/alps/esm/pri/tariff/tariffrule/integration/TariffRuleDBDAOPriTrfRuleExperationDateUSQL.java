/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TariffRuleDBDAOPriTrfRuleExperationDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.16
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.05.16 이행지
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

public class TariffRuleDBDAOPriTrfRuleExperationDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History-----------------------------------
	  * 2011.04.19 이행지 [CHM-201110201-01] Tariff Rule 관련 Status 변경 관리자 기능 추가 요청
	  *                                                         - Publish Cancel 하려는 EFF_DT와  (AMD_SEQ-1)의 EXP_DT가 연속된다면 이전 데이터의 EXP_DT를 null로 수정
	  * 2011.05.16 이행지 [CHM-201110773-01] [PRI] Tariff Rule - Publish Cancel 기능 보완
	  *                                                         - Publish Cacnel 할때 AMD Seq.가 0이상일때 Cacel하려고 하는 이전 AMD Seq. 데이터가 수정되면 변경되는 쿼리로 변경
	  * </pre>
	  */
	public TariffRuleDBDAOPriTrfRuleExperationDateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("FileName : TariffRuleDBDAOPriTrfRuleExperationDateUSQL").append("\n"); 
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
		query.append("UPDATE PRI_TRF_RULE" ).append("\n"); 
		query.append("   SET EXP_DT				= TO_DATE(@[exp_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("     , UPD_USR_ID			= @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT				= SYSDATE" ).append("\n"); 
		query.append(" WHERE TRF_PFX_CD	= @[trf_pfx_cd]" ).append("\n"); 
		query.append("   AND TRF_NO		= @[trf_no]" ).append("\n"); 
		query.append("   AND TRF_RULE_NO	= @[trf_rule_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ		= @[amdt_seq]" ).append("\n"); 

	}
}