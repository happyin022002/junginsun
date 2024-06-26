/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityGuidelineDBDAOCheckGroupCommodityInUseVORSQL.java
*@FileTitle : RFA Guideline Creation - Arbitrary[Load Excel]
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.07.30 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGroupCommodityGuidelineDBDAOCheckGroupCommodityInUseVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rate 에서 사용하는 commodity 를 조회한다.
	  * </pre>
	  */
	public RFAGroupCommodityGuidelineDBDAOCheckGroupCommodityInUseVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prc_grp_cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.pri.rfaguideline.rfagroupcommodityguideline.integration").append("\n"); 
		query.append("FileName : RFAGroupCommodityGuidelineDBDAOCheckGroupCommodityInUseVORSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) ETC1" ).append("\n"); 
		query.append("FROM PRI_RG_RT_CMDT" ).append("\n"); 
		query.append("WHERE SVC_SCP_CD    = @[svc_scp_cd]" ).append("\n"); 
		query.append("AND GLINE_SEQ       = @[gline_seq]" ).append("\n"); 
		query.append("AND PRC_CMDT_DEF_CD = @[prc_grp_cmdt_cd]" ).append("\n"); 

	}
}