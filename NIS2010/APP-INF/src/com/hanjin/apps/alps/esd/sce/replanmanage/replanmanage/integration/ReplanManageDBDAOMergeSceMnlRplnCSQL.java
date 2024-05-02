/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOMergeSceMnlRplnCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.07.05 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOMergeSceMnlRplnCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCE_MNL_RPLN 에 해당 정보를 입력 후 merge 한다. (10분 manual replan 수행)
	  * </pre>
	  */
	public ReplanManageDBDAOMergeSceMnlRplnCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mst_cop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.replanmanage.replanmanage.integration ").append("\n"); 
		query.append("FileName : ReplanManageDBDAOMergeSceMnlRplnCSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append("INTO SCE_MNL_RPLN S USING (" ).append("\n"); 
		query.append("SELECT @[cop_no] ACT_RCV_DT," ).append("\n"); 
		query.append("@[bkg_no] BKG_NO," ).append("\n"); 
		query.append("@[mst_cop_no] MST_COP_NO," ).append("\n"); 
		query.append("@[pctl_no] PCTL_NO," ).append("\n"); 
		query.append("@[io_bnd_cd] IO_BND_CD," ).append("\n"); 
		query.append("@[cre_usr_id] CRE_USR_ID," ).append("\n"); 
		query.append("SYSDATE CRE_DT," ).append("\n"); 
		query.append("@[upd_usr_id] UPD_USR_ID," ).append("\n"); 
		query.append("SYSDATE UPD_DT" ).append("\n"); 
		query.append("FROM DUAL) A ON (" ).append("\n"); 
		query.append("S.COP_NO = A.COP_NO) WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET BKG_NO = ''," ).append("\n"); 
		query.append("MST_COP_NO = ''," ).append("\n"); 
		query.append("PCTL_NO = NVL(@[pctl_no], '')," ).append("\n"); 
		query.append("RPLN_SCS_FLG = 'N'," ).append("\n"); 
		query.append("COA_IF_FLG = 'N'," ).append("\n"); 
		query.append("MNL_RPLN_RMK = 'N'," ).append("\n"); 
		query.append("CRE_USR_ID = @[cre_usr_id]," ).append("\n"); 
		query.append("CRE_DT = SYSDATE," ).append("\n"); 
		query.append("UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (S.COP_NO," ).append("\n"); 
		query.append("S.BKG_NO," ).append("\n"); 
		query.append("S.MST_COP_NO," ).append("\n"); 
		query.append("S.PCTL_NO," ).append("\n"); 
		query.append("S.IO_BND_CD," ).append("\n"); 
		query.append("S.RPLN_SCS_FLG," ).append("\n"); 
		query.append("S.COA_IF_FLG," ).append("\n"); 
		query.append("S.MNL_RPLN_RMK," ).append("\n"); 
		query.append("S.CRE_USR_ID," ).append("\n"); 
		query.append("S.UPD_USR_ID)" ).append("\n"); 
		query.append("VALUES (A.COP_NO," ).append("\n"); 
		query.append("A.BKG_NO," ).append("\n"); 
		query.append("A.MST_COP_NO," ).append("\n"); 
		query.append("A.PCTL_NO," ).append("\n"); 
		query.append("A.RPLN_SCS_FLG," ).append("\n"); 
		query.append("A.COA_IF_FLG," ).append("\n"); 
		query.append("'tmlChg'," ).append("\n"); 
		query.append("'tmlChg')" ).append("\n"); 

	}
}