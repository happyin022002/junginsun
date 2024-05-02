/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EGandEvaluatorDBDAOAddEGEVMappingHisCSQL.java
*@FileTitle : Terminal Productivity Target Input
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.16
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.16 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EGandEvaluatorDBDAOAddEGEVMappingHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EG vs Evalulator Mapping 데이터의 히스토리 정보를 입력 한다
	  * </pre>
	  */
	public EGandEvaluatorDBDAOAddEGEVMappingHisCSQL(){
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
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ev_knd_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration").append("\n"); 
		query.append("FileName : EGandEvaluatorDBDAOAddEGEVMappingHisCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_EV_GRP_EVR_HIS(EG_ID" ).append("\n"); 
		query.append("                             , EV_KND_CD" ).append("\n"); 
		query.append("                             , EV_KND_SEQ" ).append("\n"); 
		query.append("                             , EG_EVR_HIS_SEQ" ).append("\n"); 
		query.append("                             , EVR_USR_ID" ).append("\n"); 
		query.append("                             , INP_DT" ).append("\n"); 
		query.append("                             , DELT_FLG" ).append("\n"); 
		query.append("                             , CRE_USR_ID" ).append("\n"); 
		query.append("                             , CRE_DT" ).append("\n"); 
		query.append("                             , UPD_USR_ID" ).append("\n"); 
		query.append("                             , UPD_DT" ).append("\n"); 
		query.append("                               )VALUES(" ).append("\n"); 
		query.append("                               @[eg_id]" ).append("\n"); 
		query.append("                             , @[ev_knd_cd]" ).append("\n"); 
		query.append("                             , DECODE(@[ev_knd_seq],'',(SELECT MAX(EV_KND_SEQ)FROM SPE_EV_GRP_EVR WHERE EG_ID = @[eg_id]  AND EV_KND_CD = @[ev_knd_cd]),@[ev_knd_seq])" ).append("\n"); 
		query.append("                             , SPE_EV_GRP_EVR_HIS_SEQ.NEXTVAL" ).append("\n"); 
		query.append("                             , @[evr_usr_id]" ).append("\n"); 
		query.append("                             , TO_CHAR(SYSDATE,'YYYYMMDD')" ).append("\n"); 
		query.append("                             , @[delt_flg]" ).append("\n"); 
		query.append("                             , @[cre_usr_id]" ).append("\n"); 
		query.append("                             , SYSDATE" ).append("\n"); 
		query.append("                             , @[upd_usr_id]" ).append("\n"); 
		query.append("                             , SYSDATE" ).append("\n"); 
		query.append("                               )" ).append("\n"); 

	}
}