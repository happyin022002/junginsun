/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOSetCombinedNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.08.27 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOSetCombinedNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * JOO_SETTLEMENT에 Combined No 를 update한다.
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOSetCombinedNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOSetCombinedNoUSQL").append("\n"); 
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
		query.append("UPDATE JOO_SETTLEMENT" ).append("\n"); 
		query.append("SET    CMB_CFM_FLG = 'Y'" ).append("\n"); 
		query.append(",UPD_DT      = SYSDATE" ).append("\n"); 
		query.append(",UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append("WHERE  ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    TRD_CD      = @[trd_cd]" ).append("\n"); 
		query.append("#if(${re_divr_cd} != '')" ).append("\n"); 
		query.append("AND    RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    RLANE_CD  IN (" ).append("\n"); 
		query.append("#foreach($key IN ${rlane_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $rlane_cd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}