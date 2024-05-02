/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.20 장강철
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

public class SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Target Lane for SPCL CGO APVL(Create)-Update
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVOUSQL(){
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
		params.put("spcl_cgo_rqst_tgt_lane_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVOUSQL").append("\n"); 
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
		query.append("UPDATE" ).append("\n"); 
		query.append("MDM_VSL_SVC_LANE A" ).append("\n"); 
		query.append("SET  A.spcl_cgo_rqst_tgt_lane_flg =   @[spcl_cgo_rqst_tgt_lane_flg]," ).append("\n"); 
		query.append("A.UPD_USR_ID       =   @[upd_usr_id]," ).append("\n"); 
		query.append("A.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE  A.VSL_SLAN_CD  =       @[vsl_slan_cd]" ).append("\n"); 

	}
}