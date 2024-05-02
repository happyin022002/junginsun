/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOcheckAutoCreItemRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.24
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.02.24 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOcheckAutoCreItemRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOcheckAutoCreItemRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_flg1",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOcheckAutoCreItemRSQL").append("\n"); 
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
		query.append("SELECT DECODE (D.CNMV_STS_CD, NULL, 'OK(SKIP)', D.CNMV_STS_CD)||'('||D.APLY_YD_CD||')' AS AUTO," ).append("\n"); 
		query.append("       H.LST_CNMV_STS_CD AS AS_STS, " ).append("\n"); 
		query.append("       MVMT_MODI_TGT_CD AS TAR," ).append("\n"); 
		query.append("       DECODE (MVMT_YD_CHK_CD, 'E', 'ERROR', 'OK') AS RESULT," ).append("\n"); 
		query.append("       D.AUTO_CRE_SEQ," ).append("\n"); 
		query.append("       H.N1ST_MVMT_FULL_FLG," ).append("\n"); 
		query.append("       D.AUTO_MVMT_STS_SEQ," ).append("\n"); 
		query.append("       D.UPD_USR_ID AS CRE_USR_ID" ).append("\n"); 
		query.append("  FROM CTM_STS_AUTO_CRE H," ).append("\n"); 
		query.append("       CTM_STS_AUTO_CRE_DTL D" ).append("\n"); 
		query.append(" WHERE H.AUTO_CRE_SEQ = D.AUTO_CRE_SEQ(+)" ).append("\n"); 
		query.append("   AND (DECODE (@[sts_cd1], 'TN', 'EN', 'CT', 'CE', @[sts_cd1]) = 'EN'" ).append("\n"); 
		query.append("        AND N2ND_MVMT_STS_CD = DECODE (N2ND_MVMT_STS_CD, 'A', N2ND_MVMT_STS_CD, DECODE (@[sts_cd2], 'TN', 'EN', 'CT', 'CE', @[sts_cd2]))" ).append("\n"); 
		query.append("         OR DECODE (@[sts_cd1], 'TN', 'EN', 'CT', 'CE', @[sts_cd1]) <> 'EN')" ).append("\n"); 
		query.append("   AND N1ST_MVMT_STS_CD = DECODE (@[sts_cd1], 'TN', 'EN', 'CT', 'CE', @[sts_cd1])" ).append("\n"); 
		query.append("   AND NVL (N2ND_MVMT_FULL_FLG, 'A') = DECODE (N2ND_MVMT_FULL_FLG, NULL, NVL (N2ND_MVMT_FULL_FLG, 'A'), DECODE (@[fm_flg1], 'Y', 'F', 'N', 'M', @[fm_flg1]))" ).append("\n"); 
		query.append("   AND H.CNMV_STS_CD = DECODE (@[sts_cd], 'TN', 'EN', 'CT', 'CE', @[sts_cd])" ).append("\n"); 
		query.append("   AND NVL (N1ST_MVMT_FULL_FLG, 'A') = DECODE (N1ST_MVMT_FULL_FLG, NULL, NVL (N1ST_MVMT_FULL_FLG, 'A'), DECODE (@[fm_flg], 'Y', 'F', 'N', 'M', @[fm_flg]))" ).append("\n"); 
		query.append("   AND MVMT_YD_CHK_CD = DECODE (MVMT_YD_CHK_CD, 'A', MVMT_YD_CHK_CD, 'E', MVMT_YD_CHK_CD, @[org_yd])" ).append("\n"); 

	}
}