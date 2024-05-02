/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsReportDBDAOaddDelModeCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier :
*@LastVersion : 1.0
* 2009.09.14
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsReportDBDAOaddDelModeCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * 중국 DEL 별 운송 Mode 입력.
	  * </pre>
	  */
	public ChinaCustomsReportDBDAOaddDelModeCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("area_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.integration").append("\n");
		query.append("FileName : ChinaCustomsReportDBDAOaddDelModeCSQL").append("\n");
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
		query.append("INSERT INTO BKG_CSTMS_CHN_DE_MOD (" ).append("\n");
		query.append("POD_CD" ).append("\n");
		query.append(",	DEL_CD" ).append("\n");
		query.append(",	AREA_NM" ).append("\n");
		query.append(",	CHN_CSTMS_TRSP_MOD_CD" ).append("\n");
		query.append(",	DIFF_RMK" ).append("\n");
		query.append(",	CRE_USR_ID" ).append("\n");
		query.append(",	CRE_DT" ).append("\n");
		query.append(",	UPD_USR_ID" ).append("\n");
		query.append(",	UPD_DT" ).append("\n");
		query.append(") VALUES(" ).append("\n");
		query.append("@[pod_cd]" ).append("\n");
		query.append(",	@[del_cd]" ).append("\n");
		query.append(",	@[area_nm]" ).append("\n");
		query.append(",	@[trsp_mod_cd]" ).append("\n");
		query.append(",	@[diff_rmk]" ).append("\n");
		query.append(",	@[cre_usr_id]" ).append("\n");
		query.append(",	sysdate" ).append("\n");
		query.append(",	@[upd_usr_id]" ).append("\n");
		query.append(",	sysdate" ).append("\n");
		query.append(")" ).append("\n");

	}
}