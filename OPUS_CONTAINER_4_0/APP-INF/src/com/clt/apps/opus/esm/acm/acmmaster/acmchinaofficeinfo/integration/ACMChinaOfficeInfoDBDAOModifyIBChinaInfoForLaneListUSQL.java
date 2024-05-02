/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMChinaOfficeInfoDBDAOModifyIBChinaInfoForLaneListUSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.15 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang-Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ACMChinaOfficeInfoDBDAOModifyIBChinaInfoForLaneListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  *
	  * </pre>
	  */
	public ACMChinaOfficeInfoDBDAOModifyIBChinaInfoForLaneListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("org_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.acm.acmmaster.acmchinaofficeinfo.integration").append("\n");
		query.append("FileName : ACMChinaOfficeInfoDBDAOModifyIBChinaInfoForLaneListUSQL").append("\n");
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
		query.append("UPDATE ACM_AGN_SET_NRTH_CHN_LANE" ).append("\n");
		query.append("   SET POD_CD = @[pod_cd]," ).append("\n");
		query.append("       SLAN_CD = @[slan_cd]," ).append("\n");
		query.append("       AGN_CD = @[agn_cd]," ).append("\n");
		query.append("       VNDR_CNT_CD = (SELECT VNDR_CNT_CD FROM MDM_VENDOR WHERE VNDR_SEQ = @[vndr_seq])," ).append("\n");
		query.append("       VNDR_SEQ = @[vndr_seq]," ).append("\n");
		query.append("       AGN_AR_OFC_CD = (SELECT B.FINC_OFC_CD FROM BKG_CHN_AGN B WHERE B.CHN_AGN_CD = SUBSTR(@[agn_cd],4,2) )," ).append("\n");
		query.append("       DELT_FLG = @[delt_flg]," ).append("\n");
		query.append("       UPD_USR_ID = @[usr_id]," ).append("\n");
		query.append("       UPD_DT = SYSDATE" ).append("\n");
		query.append(" WHERE POD_CD = @[org_pod_cd]" ).append("\n");
		query.append("   AND SLAN_CD = @[org_slan_cd]" ).append("\n");

	}
}