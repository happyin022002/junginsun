/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.02
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.11.02 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_tgt_lane_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVORSQL").append("\n"); 
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
		query.append("A.VSL_SLAN_CD, A.VSL_SLAN_NM, A.VSL_SVC_TP_CD, A.spcl_cgo_rqst_tgt_lane_flg,A.TML_PROD_RPT_FLG," ).append("\n"); 
		query.append("A.UPD_USR_ID,A.UPD_DT," ).append("\n"); 
		query.append("(SELECT D.INTG_CD_VAL_DP_DESC FROM COM_INTG_CD_DTL D" ).append("\n"); 
		query.append("WHERE D.INTG_CD_ID = 'CD00717' AND  D.INTG_CD_VAL_CTNT = A.VSL_SVC_TP_CD )SVC_TYPE_NAME" ).append("\n"); 
		query.append("FROM MDM_VSL_SVC_LANE A" ).append("\n"); 
		query.append("WHERE    1 = 1" ).append("\n"); 
		query.append("#if (${spcl_cgo_rqst_tgt_lane_flg} != '')" ).append("\n"); 
		query.append("AND A.spcl_cgo_rqst_tgt_lane_flg = @[spcl_cgo_rqst_tgt_lane_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND A.DELT_FLG='N'" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '')" ).append("\n"); 
		query.append("AND  A.VSL_SLAN_CD =  @[vsl_slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.VSL_SLAN_CD" ).append("\n"); 

	}
}