/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupDBDAOAddEGCreCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.17
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.17 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupDBDAOAddEGCreCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EG 테이블에 신규데이터를 저장한다.
	  * </pre>
	  */
	public EvaluationGroupDBDAOAddEGCreCSQL(){
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
		params.put("eg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration").append("\n"); 
		query.append("FileName : EvaluationGroupDBDAOAddEGCreCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_EV_GRP(EG_ID" ).append("\n"); 
		query.append("                     , EG_NM" ).append("\n"); 
		query.append("                     , EG_RHQ_CD" ).append("\n"); 
		query.append("                     , EG_OFC_CD" ).append("\n"); 
		query.append("                     , EV_SVC_CATE_CD" ).append("\n"); 
		query.append("                     , DELT_FLG" ).append("\n"); 
		query.append("                     , CRE_USR_ID" ).append("\n"); 
		query.append("                     , CRE_DT" ).append("\n"); 
		query.append("                     , UPD_USR_ID" ).append("\n"); 
		query.append("                     , UPD_DT" ).append("\n"); 
		query.append("                     )VALUES(" ).append("\n"); 
		query.append("                       'EG'||SUBSTR(@[eg_rhq_cd],0,3)||(SELECT LPAD(COUNT(1)+1,4,0) FROM SPE_EV_GRP WHERE  EG_ID LIKE 'EG'||SUBSTR(@[eg_rhq_cd],0,3)||'%')" ).append("\n"); 
		query.append("                     , SUBSTR(@[eg_rhq_cd],0,3)||'-'||@[eg_ofc_cd]||'-'||(SELECT INTG_CD_VAL_CTNT FROM COM_INTG_CD_DTL WHERE INTG_CD_VAL_CTNT = @[ev_svc_cate_cd] AND INTG_CD_ID ='CD03377')" ).append("\n"); 
		query.append("                     , @[eg_rhq_cd]" ).append("\n"); 
		query.append("                     , @[eg_ofc_cd]" ).append("\n"); 
		query.append("                     , @[ev_svc_cate_cd]" ).append("\n"); 
		query.append("                     , 'N'" ).append("\n"); 
		query.append("                     , @[cre_usr_id]" ).append("\n"); 
		query.append("                     , SYSDATE" ).append("\n"); 
		query.append("                     , @[upd_usr_id]" ).append("\n"); 
		query.append("                     , SYSDATE  " ).append("\n"); 
		query.append("                     )" ).append("\n"); 

	}
}