/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupMappingDBDAOModifyEGBEMappingUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.25
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.25 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupMappingDBDAOModifyEGBEMappingUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EG vs Evalulator Mapping 데이터를 수정 한다
	  * </pre>
	  */
	public EvaluationGroupMappingDBDAOModifyEGBEMappingUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bzc_ev_grd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sp_bzc_eg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration").append("\n"); 
		query.append("FileName : EvaluationGroupMappingDBDAOModifyEGBEMappingUSQL").append("\n"); 
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
		query.append("UPDATE SPE_SP_BZC_EV_GRP" ).append("\n"); 
		query.append("   SET BZC_EV_GRD_CD   = @[bzc_ev_grd_cd]" ).append("\n"); 
		query.append("     , EV_YR           = @[ev_yr]" ).append("\n"); 
		query.append("     , EV_DT           = (SELECT CASE WHEN NVL(BZC_EV_GRD_CD,'A') = NVL(@[bzc_ev_grd_cd],'A') THEN EV_DT ELSE SYSDATE  END FROM SPE_SP_BZC_EV_GRP" ).append("\n"); 
		query.append("                          WHERE SP_BZC_EG_SEQ    = @[sp_bzc_eg_seq]" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("     , UPD_USR_ID      = @[upd_usr_id]" ).append("\n"); 
		query.append("     , UPD_DT          = SYSDATE" ).append("\n"); 
		query.append("     , SP_SEQ          = @[sp_seq]" ).append("\n"); 
		query.append(" WHERE EG_ID = @[eg_id]" ).append("\n"); 
		query.append("   AND SP_BZC_EG_SEQ    = @[sp_bzc_eg_seq]" ).append("\n"); 

	}
}