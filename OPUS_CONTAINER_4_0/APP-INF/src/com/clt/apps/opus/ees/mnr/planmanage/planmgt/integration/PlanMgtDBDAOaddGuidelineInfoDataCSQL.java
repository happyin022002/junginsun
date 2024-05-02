/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtDBDAOaddGuidelineInfoDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.16
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.06.16 이주현
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOaddGuidelineInfoDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Guideline 정보를 Insert시키는 Operation이다.
	  * </pre>
	  */
	public PlanMgtDBDAOaddGuidelineInfoDataCSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_gline_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_gline_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("INSERT INTO MNR_GUIDELINE(" ).append("\n"); 
		query.append("MNR_GLINE_SEQ" ).append("\n"); 
		query.append(",MNR_GRP_TP_CD" ).append("\n"); 
		query.append(",MNR_GLINE_NM" ).append("\n"); 
		query.append(",MNR_GLINE_RMK" ).append("\n"); 
		query.append(",FILE_SEQ" ).append("\n"); 
		query.append(",FILE_DTL_SEQ" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("mnr_gline_seq.nextval" ).append("\n"); 
		query.append(",@[mnr_grp_tp_cd]" ).append("\n"); 
		query.append(",@[mnr_gline_nm]" ).append("\n"); 
		query.append(",@[mnr_gline_rmk]" ).append("\n"); 
		query.append(",NVL(@[file_seq], 0)" ).append("\n"); 
		query.append(",NVL(@[file_dtl_seq],1)" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOaddGuidelineInfoDataCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}