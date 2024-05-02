/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SI Analysis Result 테이블 Update
	  * </pre>
	  */
	public EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ds_scre",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bi_scre",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltUSQL").append("\n"); 
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
		query.append("UPDATE SPE_EV_GRP_STRG_IMPT_RSLT" ).append("\n"); 
		query.append("SET BI_SCRE = TO_NUMBER(@[bi_scre])," ).append("\n"); 
		query.append("DS_SCRE = TO_NUMBER(@[ds_scre])," ).append("\n"); 
		query.append("SI_SCRE = ROUND( CASE WHEN @[si_grp_cd] = 'CR'" ).append("\n"); 
		query.append("THEN SQRT(((TO_NUMBER(@[bi_scre]) - 2.5) * (TO_NUMBER(@[bi_scre]) - 2.5)) + ((TO_NUMBER(@[ds_scre]) - 2.5) * (TO_NUMBER(@[ds_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[si_grp_cd] = 'LV'" ).append("\n"); 
		query.append("THEN SQRT(((TO_NUMBER(@[bi_scre]) - 2.5) * (TO_NUMBER(@[bi_scre]) - 2.5)) + (TO_NUMBER(@[ds_scre]) * TO_NUMBER(@[ds_scre])))" ).append("\n"); 
		query.append("WHEN @[si_grp_cd] = 'BN'" ).append("\n"); 
		query.append("THEN SQRT((TO_NUMBER(@[bi_scre]) * TO_NUMBER(@[bi_scre]) ) + ((TO_NUMBER(@[ds_scre]) - 2.5) * (TO_NUMBER(@[ds_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[si_grp_cd] = 'RT'" ).append("\n"); 
		query.append("THEN SQRT((TO_NUMBER(@[bi_scre]) * TO_NUMBER(@[bi_scre])) + (TO_NUMBER(@[ds_scre]) * TO_NUMBER(@[ds_scre]))) END , 2)," ).append("\n"); 
		query.append("SI_GRP_CD = @[si_grp_cd]," ).append("\n"); 
		query.append("SI_GRP_NM = @[si_grp_nm]," ).append("\n"); 
		query.append("UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHERE EV_YR = @[ev_yr]" ).append("\n"); 
		query.append("AND EG_ID = @[eg_id]" ).append("\n"); 
		query.append("AND EG_ID_SEQ = @[eg_id_seq]" ).append("\n"); 

	}
}