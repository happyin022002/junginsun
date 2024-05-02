/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtDBDAOsearchCodeRelationByLocationDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.28 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOsearchCodeRelationByLocationDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 by Location
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOsearchCodeRelationByLocationDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_cmpo_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.integration").append("\n"); 
		query.append("FileName : CEDEXCodeMgtDBDAOsearchCodeRelationByLocationDataRSQL").append("\n"); 
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
		query.append("SELECT DECODE(C.TO_RLT_CD,@[eq_cmpo_cd],'Y','N')  G," ).append("\n"); 
		query.append("C.EQ_LOC_CD  CODE," ).append("\n"); 
		query.append("C.EQ_LOC_NM  DESCRIPTION," ).append("\n"); 
		query.append("DECODE(C.EQ_CEDEX_RLT_TP_CD,NULL,'LTC',C.EQ_CEDEX_RLT_TP_CD) EQ_CEDEX_RLT_TP_CD," ).append("\n"); 
		query.append("DECODE(C.FM_RLT_CD,NULL,C.EQ_LOC_CD,C.FM_RLT_CD)  FM_RLT_CD," ).append("\n"); 
		query.append("DECODE(C.TO_RLT_CD,NULL,@[eq_cmpo_cd],C.TO_RLT_CD)  TO_RLT_CD," ).append("\n"); 
		query.append("C.CRE_USR_ID," ).append("\n"); 
		query.append("C.CRE_DT," ).append("\n"); 
		query.append("C.UPD_USR_ID," ).append("\n"); 
		query.append("C.UPD_DT," ).append("\n"); 
		query.append("@[eq_cmpo_cd] EQ_CMPO_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.EQ_LOC_CD," ).append("\n"); 
		query.append("A.EQ_LOC_NM," ).append("\n"); 
		query.append("B.EQ_CEDEX_RLT_TP_CD," ).append("\n"); 
		query.append("B.FM_RLT_CD," ).append("\n"); 
		query.append("B.TO_RLT_CD," ).append("\n"); 
		query.append("B.CRE_USR_ID," ).append("\n"); 
		query.append("B.CRE_DT," ).append("\n"); 
		query.append("B.UPD_USR_ID," ).append("\n"); 
		query.append("B.UPD_DT" ).append("\n"); 
		query.append("FROM (SELECT EQ_LOC_CD," ).append("\n"); 
		query.append("EQ_LOC_NM" ).append("\n"); 
		query.append("FROM MNR_EQ_LOC_CD" ).append("\n"); 
		query.append("WHERE EQ_LOC_CD_LVL = '2') A," ).append("\n"); 
		query.append("(SELECT EQ_CEDEX_RLT_TP_CD," ).append("\n"); 
		query.append("FM_RLT_CD," ).append("\n"); 
		query.append("TO_RLT_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM MNR_CD_RLT" ).append("\n"); 
		query.append("WHERE EQ_CEDEX_RLT_TP_CD = 'LTC'" ).append("\n"); 
		query.append("AND TO_RLT_CD = @[eq_cmpo_cd]) B" ).append("\n"); 
		query.append("WHERE A.EQ_LOC_CD = B.FM_RLT_CD(+)" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("( SELECT @[eq_cmpo_cd] EQ_CMPO_CD" ).append("\n"); 
		query.append("FROM DUAL ) P" ).append("\n"); 
		query.append("WHERE C.TO_RLT_CD = P.EQ_CMPO_CD(+)" ).append("\n"); 
		query.append("ORDER BY G DESC, CODE" ).append("\n"); 

	}
}