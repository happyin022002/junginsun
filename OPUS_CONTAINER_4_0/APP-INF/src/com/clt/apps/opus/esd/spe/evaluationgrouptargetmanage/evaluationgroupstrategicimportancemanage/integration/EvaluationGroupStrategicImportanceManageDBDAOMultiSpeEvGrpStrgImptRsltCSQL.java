/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltCSQL.java
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

public class EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SI Analysis Result 테이블에 Insert
	  * </pre>
	  */
	public EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("si_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bi_scre",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.integration ").append("\n"); 
		query.append("FileName : EvaluationGroupStrategicImportanceManageDBDAOMultiSpeEvGrpStrgImptRsltCSQL").append("\n"); 
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
		query.append("INSERT INTO SPE_EV_GRP_STRG_IMPT_RSLT" ).append("\n"); 
		query.append("(EG_ID ," ).append("\n"); 
		query.append("EG_ID_SEQ ," ).append("\n"); 
		query.append("EV_YR ," ).append("\n"); 
		query.append("BI_SCRE ," ).append("\n"); 
		query.append("DS_SCRE ," ).append("\n"); 
		query.append("SI_SCRE ," ).append("\n"); 
		query.append("SI_GRP_CD ," ).append("\n"); 
		query.append("SI_GRP_NM ," ).append("\n"); 
		query.append("CRE_USR_ID ," ).append("\n"); 
		query.append("CRE_DT ," ).append("\n"); 
		query.append("UPD_USR_ID ," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES ( @[eg_id]" ).append("\n"); 
		query.append(",@[eg_id_seq]" ).append("\n"); 
		query.append(",@[ev_yr]" ).append("\n"); 
		query.append(",TO_NUMBER(@[bi_scre]) -- bi_scre" ).append("\n"); 
		query.append(",TO_NUMBER(@[ds_scre]) -- ds_scre" ).append("\n"); 
		query.append(",ROUND( CASE WHEN @[si_grp_cd] = 'CR'" ).append("\n"); 
		query.append("THEN SQRT(((TO_NUMBER(@[bi_scre]) - 2.5) * (TO_NUMBER(@[bi_scre]) - 2.5)) + ((TO_NUMBER(@[ds_scre]) - 2.5) * (TO_NUMBER(@[ds_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[si_grp_cd] = 'LV'" ).append("\n"); 
		query.append("THEN SQRT(((TO_NUMBER(@[bi_scre]) - 2.5) * (TO_NUMBER(@[bi_scre]) - 2.5)) + (TO_NUMBER(@[ds_scre]) * TO_NUMBER(@[ds_scre])))" ).append("\n"); 
		query.append("WHEN @[si_grp_cd] = 'BN'" ).append("\n"); 
		query.append("THEN SQRT((TO_NUMBER(@[bi_scre]) * TO_NUMBER(@[bi_scre]) ) + ((TO_NUMBER(@[ds_scre]) - 2.5) * (TO_NUMBER(@[ds_scre]) - 2.5)))" ).append("\n"); 
		query.append("WHEN @[si_grp_cd] = 'RT'" ).append("\n"); 
		query.append("THEN SQRT((TO_NUMBER(@[bi_scre]) * TO_NUMBER(@[bi_scre])) + (TO_NUMBER(@[ds_scre]) * TO_NUMBER(@[ds_scre]))) END , 2) -- si_scre" ).append("\n"); 
		query.append(",@[si_grp_cd] -- si_grp_cd" ).append("\n"); 
		query.append(",@[si_grp_nm] -- si_grp_nm" ).append("\n"); 
		query.append(",@[cre_usr_id]-- cre_usr_id" ).append("\n"); 
		query.append(",SYSDATE -- cre_dt" ).append("\n"); 
		query.append(",@[upd_usr_id] -- upd_usr_id" ).append("\n"); 
		query.append(",SYSDATE -- upd_dt" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}