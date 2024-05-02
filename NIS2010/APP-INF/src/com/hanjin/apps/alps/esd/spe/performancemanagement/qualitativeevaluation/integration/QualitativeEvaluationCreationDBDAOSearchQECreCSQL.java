/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationCreationDBDAOSearchQECreCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.05 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QualitativeEvaluationCreationDBDAOSearchQECreCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Qualitative Evaluation 테이블에 신규데이터를 저장한다.
	  * </pre>
	  */
	public QualitativeEvaluationCreationDBDAOSearchQECreCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_area_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n2nd_ev_grd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("n1st_ev_grd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ev_fctr_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("n3rd_ev_grd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ev_wgt_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration").append("\n"); 
		query.append("FileName : QualitativeEvaluationCreationDBDAOSearchQECreCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_QUAL_EV(" ).append("\n"); 
		query.append("					 EV_YR" ).append("\n"); 
		query.append("					,EV_SVC_CATE_CD" ).append("\n"); 
		query.append("					,QUAL_EV_SEQ" ).append("\n"); 
		query.append("					,EV_AREA_CTNT" ).append("\n"); 
		query.append("					,EV_FCTR_CTNT" ).append("\n"); 
		query.append("					,EV_WGT_RT" ).append("\n"); 
		query.append("					,N1ST_EV_GRD_CTNT" ).append("\n"); 
		query.append("					,N2ND_EV_GRD_CTNT" ).append("\n"); 
		query.append("					,N3RD_EV_GRD_CTNT" ).append("\n"); 
		query.append("					,CRE_USR_ID" ).append("\n"); 
		query.append("					,CRE_DT" ).append("\n"); 
		query.append("					,UPD_USR_ID" ).append("\n"); 
		query.append("					,UPD_DT" ).append("\n"); 
		query.append("        )VALUES(" ).append("\n"); 
		query.append("                     @[ev_yr]" ).append("\n"); 
		query.append("					,@[ev_svc_cate_cd]" ).append("\n"); 
		query.append("					,SPE_QUAL_EV_SEQ.nextval " ).append("\n"); 
		query.append("					,@[ev_area_ctnt]" ).append("\n"); 
		query.append("					,@[ev_fctr_ctnt]" ).append("\n"); 
		query.append("					,@[ev_wgt_rt]" ).append("\n"); 
		query.append("					,@[n1st_ev_grd_ctnt]" ).append("\n"); 
		query.append("					,@[n2nd_ev_grd_ctnt]" ).append("\n"); 
		query.append("					,@[n3rd_ev_grd_ctnt]" ).append("\n"); 
		query.append("					,@[cre_usr_id]" ).append("\n"); 
		query.append("					,SYSDATE" ).append("\n"); 
		query.append("					,@[upd_usr_id]" ).append("\n"); 
		query.append("					,SYSDATE" ).append("\n"); 
		query.append("                     )" ).append("\n"); 

	}
}