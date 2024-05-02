/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAOAddCntrTpSzGrpListCSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.25 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMSetupDBDAOAddCntrTpSzGrpListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMSetupDBDAOAddCntrTpSzGrpListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_grp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration").append("\n");
		query.append("FileName : ACMSetupDBDAOAddCntrTpSzGrpListCSQL").append("\n");
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
		query.append("INSERT INTO ACM_AGN_SET_CNTR_GRP" ).append("\n");
		query.append("       (CNTR_TPSZ_GRP_NM," ).append("\n");
		query.append("        CNTR_TPSZ_CD," ).append("\n");
		query.append("        CRE_USR_ID," ).append("\n");
		query.append("        CRE_DT," ).append("\n");
		query.append("        UPD_USR_ID," ).append("\n");
		query.append("        UPD_DT)" ).append("\n");
		query.append("" ).append("\n");
		query.append("VALUES (@[cntr_tpsz_grp_nm]," ).append("\n");
		query.append("        @[cntr_tpsz_cd]," ).append("\n");
		query.append("        @[usr_id]," ).append("\n");
		query.append("        SYSDATE," ).append("\n");
		query.append("        @[usr_id]," ).append("\n");
		query.append("        SYSDATE)" ).append("\n");

	}
}