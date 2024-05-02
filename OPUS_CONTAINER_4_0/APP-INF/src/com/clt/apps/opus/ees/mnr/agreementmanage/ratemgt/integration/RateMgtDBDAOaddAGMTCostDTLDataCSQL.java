/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtDBDAOaddAGMTCostDTLDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.24 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RateMgtDBDAOaddAGMTCostDTLDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addAGMTCostDTLData
	  * </pre>
	  */
	public RateMgtDBDAOaddAGMTCostDTLDataCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO MNR_AGMT_COST_DTL_CD(" ).append("\n"); 
		query.append("AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",AGMT_SEQ" ).append("\n"); 
		query.append(",AGMT_VER_NO" ).append("\n"); 
		query.append(",COST_CD" ).append("\n"); 
		query.append(",COST_DTL_CD" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",A.AGMT_SEQ" ).append("\n"); 
		query.append(",A.AGMT_VER_NO" ).append("\n"); 
		query.append(",A.COST_CD" ).append("\n"); 
		query.append(",A.COST_DTL_CD" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append("FROM  MNR_AGMT_RT A" ).append("\n"); 
		query.append("WHERE A.AGMT_OFC_CTY_CD = @[agmt_ofc_cty_cd]" ).append("\n"); 
		query.append("AND   A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("AND   A.AGMT_VER_NO = @[agmt_ver_no]" ).append("\n"); 
		query.append("GROUP BY" ).append("\n"); 
		query.append("A.AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append(",A.AGMT_SEQ" ).append("\n"); 
		query.append(",A.AGMT_VER_NO" ).append("\n"); 
		query.append(",A.COST_CD" ).append("\n"); 
		query.append(",A.COST_DTL_CD" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration ").append("\n"); 
		query.append("FileName : RateMgtDBDAOaddAGMTCostDTLDataCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}