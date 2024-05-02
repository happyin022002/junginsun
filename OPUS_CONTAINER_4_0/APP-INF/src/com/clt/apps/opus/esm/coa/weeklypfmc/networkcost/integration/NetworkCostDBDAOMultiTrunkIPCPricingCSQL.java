/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : NetworkCostDBDAOMultiTrunkIPCPricingCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.03
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.11.03 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class NetworkCostDBDAOMultiTrunkIPCPricingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * History ----------------------------
	  * 2010.10.22 이행지 [CHM-201006375-01][COA] Trunk IPC와 Ocean간 내부거래 신규 추가 
	  *                                                        - Trunk IPC Internal Pricing 화면 Save 버튼적용 삽입쿼리
	  * </pre>
	  */
	public NetworkCostDBDAOMultiTrunkIPCPricingCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_prc_uc_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.integration").append("\n"); 
		query.append("FileName : NetworkCostDBDAOMultiTrunkIPCPricingCSQL").append("\n"); 
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
		query.append("INSERT INTO COA_INTER_PRC_UT_COST (" ).append("\n"); 
		query.append("	COST_YRMON" ).append("\n"); 
		query.append(",	TRD_CD" ).append("\n"); 
		query.append(",	CURR_CD" ).append("\n"); 
		query.append(",	INTER_PRC_UC_AMT" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[cost_yrmon]" ).append("\n"); 
		query.append(",	@[trd_cd]" ).append("\n"); 
		query.append(",	'USD'       -- [curr_cd]" ).append("\n"); 
		query.append(",	@[inter_prc_uc_amt]" ).append("\n"); 
		query.append(",	'N'      --[delt_flg]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	TO_DATE(SYSDATE,'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	TO_DATE(@[SYSDATE,'YYYY-MM-DD')" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}