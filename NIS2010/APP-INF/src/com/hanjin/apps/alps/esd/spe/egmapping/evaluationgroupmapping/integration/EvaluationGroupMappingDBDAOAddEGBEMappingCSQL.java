/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupMappingDBDAOAddEGBEMappingCSQL.java
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

public class EvaluationGroupMappingDBDAOAddEGBEMappingCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EG vs Evalulator Mapping 데이터를 입력 한다
	  * </pre>
	  */
	public EvaluationGroupMappingDBDAOAddEGBEMappingCSQL(){
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
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evr_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration").append("\n"); 
		query.append("FileName : EvaluationGroupMappingDBDAOAddEGBEMappingCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_SP_BZC_EV_GRP(EG_ID" ).append("\n"); 
		query.append("                            , SP_BZC_EG_SEQ" ).append("\n"); 
		query.append("                            , SP_SEQ" ).append("\n"); 
		query.append("                            , EV_YR" ).append("\n"); 
		query.append("                            , BZC_EV_GRD_CD" ).append("\n"); 
		query.append("                            , EVR_USR_ID" ).append("\n"); 
		query.append("                            , EV_DT" ).append("\n"); 
		query.append("                            , DELT_FLG" ).append("\n"); 
		query.append("                            , CRE_USR_ID" ).append("\n"); 
		query.append("                            , CRE_DT" ).append("\n"); 
		query.append("                            , UPD_USR_ID" ).append("\n"); 
		query.append("                            , UPD_DT" ).append("\n"); 
		query.append("                             )VALUES(" ).append("\n"); 
		query.append("                              @[eg_id]" ).append("\n"); 
		query.append("                            , SPE_SP_BZC_EV_GRP_SEQ.NEXTVAL" ).append("\n"); 
		query.append("                            , @[sp_seq]" ).append("\n"); 
		query.append("                            , @[ev_yr]" ).append("\n"); 
		query.append("                            , @[bzc_ev_grd_cd]" ).append("\n"); 
		query.append("                            , DECODE(@[bzc_ev_grd_cd],NULL,'',@[evr_usr_id])" ).append("\n"); 
		query.append("                            , DECODE(@[bzc_ev_grd_cd],NULL,'',SYSDATE)" ).append("\n"); 
		query.append("                            , 'N'" ).append("\n"); 
		query.append("                            , @[cre_usr_id]" ).append("\n"); 
		query.append("                            , SYSDATE" ).append("\n"); 
		query.append("                            , @[upd_usr_id]" ).append("\n"); 
		query.append("                            , SYSDATE" ).append("\n"); 
		query.append("                             )" ).append("\n"); 

	}
}