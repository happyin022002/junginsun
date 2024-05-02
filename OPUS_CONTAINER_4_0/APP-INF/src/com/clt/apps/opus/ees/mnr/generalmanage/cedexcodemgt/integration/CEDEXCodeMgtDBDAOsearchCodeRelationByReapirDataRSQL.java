/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CEDEXCodeMgtDBDAOsearchCodeRelationByReapirDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.28
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.07.28 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CEDEXCodeMgtDBDAOsearchCodeRelationByReapirDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCodeRelationByReapirData Repair코드 조회
	  * </pre>
	  */
	public CEDEXCodeMgtDBDAOsearchCodeRelationByReapirDataRSQL(){
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
		query.append("Path : com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration ").append("\n"); 
		query.append("FileName : CEDEXCodeMgtDBDAOsearchCodeRelationByReapirDataRSQL").append("\n"); 
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
		query.append("SELECT DECODE(C.FM_RLT_CD,@[eq_cmpo_cd],'Y','N')  G," ).append("\n"); 
		query.append("C.EQ_CEDEX_OTR_CD     CODE," ).append("\n"); 
		query.append("C.EQ_CEDEX_OTR_CD_NM  DESCRIPTION," ).append("\n"); 
		query.append("DECODE(C.EQ_CEDEX_RLT_TP_CD,NULL,'CTR',C.EQ_CEDEX_RLT_TP_CD) EQ_CEDEX_RLT_TP_CD," ).append("\n"); 
		query.append("DECODE(C.FM_RLT_CD,NULL,@[eq_cmpo_cd],C.FM_RLT_CD)  FM_RLT_CD," ).append("\n"); 
		query.append("DECODE(C.TO_RLT_CD,NULL,C.EQ_CEDEX_OTR_CD,C.TO_RLT_CD)  TO_RLT_CD," ).append("\n"); 
		query.append("C.CRE_USR_ID," ).append("\n"); 
		query.append("C.CRE_DT," ).append("\n"); 
		query.append("C.UPD_USR_ID," ).append("\n"); 
		query.append("C.UPD_DT," ).append("\n"); 
		query.append("@[eq_cmpo_cd] EQ_CMPO_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.EQ_CEDEX_OTR_CD," ).append("\n"); 
		query.append("A.EQ_CEDEX_OTR_CD_NM," ).append("\n"); 
		query.append("B.EQ_CEDEX_RLT_TP_CD," ).append("\n"); 
		query.append("B.FM_RLT_CD," ).append("\n"); 
		query.append("B.TO_RLT_CD," ).append("\n"); 
		query.append("B.CRE_USR_ID," ).append("\n"); 
		query.append("B.CRE_DT," ).append("\n"); 
		query.append("B.UPD_USR_ID," ).append("\n"); 
		query.append("B.UPD_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT EQ_CEDEX_OTR_CD," ).append("\n"); 
		query.append("EQ_CEDEX_OTR_CD_NM" ).append("\n"); 
		query.append("FROM MNR_CEDEX_OTR_CD" ).append("\n"); 
		query.append("WHERE EQ_CEDEX_OTR_TP_CD = 'RPR'" ).append("\n"); 
		query.append(") A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT EQ_CEDEX_RLT_TP_CD," ).append("\n"); 
		query.append("FM_RLT_CD," ).append("\n"); 
		query.append("TO_RLT_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append("FROM MNR_CD_RLT" ).append("\n"); 
		query.append("WHERE EQ_CEDEX_RLT_TP_CD = 'CTR'" ).append("\n"); 
		query.append("AND FM_RLT_CD = @[eq_cmpo_cd]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.EQ_CEDEX_OTR_CD = B.TO_RLT_CD(+)" ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("( SELECT @[eq_cmpo_cd] EQ_CMPO_CD" ).append("\n"); 
		query.append("FROM DUAL ) P" ).append("\n"); 
		query.append("WHERE C.TO_RLT_CD = P.EQ_CMPO_CD(+)" ).append("\n"); 
		query.append("ORDER BY G DESC, CODE" ).append("\n"); 

	}
}