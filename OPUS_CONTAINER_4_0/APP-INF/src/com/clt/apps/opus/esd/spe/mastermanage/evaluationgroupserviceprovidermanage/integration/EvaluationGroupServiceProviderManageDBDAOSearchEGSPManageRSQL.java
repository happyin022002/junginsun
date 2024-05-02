/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupServiceProviderManageDBDAOSearchEGSPManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupServiceProviderManageDBDAOSearchEGSPManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEGSPManage
	  * </pre>
	  */
	public EvaluationGroupServiceProviderManageDBDAOSearchEGSPManageRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupServiceProviderManageDBDAOSearchEGSPManageRSQL").append("\n"); 
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
		query.append("SELECT A.EG_ID," ).append("\n"); 
		query.append("A.EG_ID_SEQ," ).append("\n"); 
		query.append("LPAD(A.VNDR_SEQ, 6, '0') AS  VNDR_SEQ," ).append("\n"); 
		query.append("B.VNDR_LGL_ENG_NM," ).append("\n"); 
		query.append("A.ENG_VNDR_RMK ," ).append("\n"); 
		query.append("C.EG_RHQ_CD," ).append("\n"); 
		query.append("C.EG_CTY_CD," ).append("\n"); 
		query.append("C.SVC_CATE_CD ," ).append("\n"); 
		query.append("A.EG_ID||TO_CHAR(A.EG_ID_SEQ, '000') AS EG_ID_ETC" ).append("\n"); 
		query.append("FROM SPE_EV_GRP_SVC_PROV_MTCH A," ).append("\n"); 
		query.append("MDM_VENDOR B," ).append("\n"); 
		query.append("SPE_EV_GRP C" ).append("\n"); 
		query.append("WHERE A.VNDR_SEQ = B.VNDR_SEQ" ).append("\n"); 
		query.append("AND ( A.EG_ID = C.EG_ID" ).append("\n"); 
		query.append("AND A.EG_ID_SEQ = C.EG_ID_SEQ )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${eg_id}!='')" ).append("\n"); 
		query.append("AND   A.EG_ID = SUBSTR(@[eg_id],1,5)" ).append("\n"); 
		query.append("AND   A.EG_ID_SEQ = TO_NUMBER(SUBSTR(@[eg_id],7,3))" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ IN (SELECT VNDR_SEQ" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH S, SPE_EV_GRP V" ).append("\n"); 
		query.append("WHERE  A.EG_ID = V.EG_ID" ).append("\n"); 
		query.append("AND    A.EG_ID_SEQ = V.EG_ID_SEQ" ).append("\n"); 
		query.append("AND    A.EG_ID = SUBSTR(@[eg_id],1,5)" ).append("\n"); 
		query.append("AND    A.EG_ID_SEQ = TO_NUMBER(SUBSTR(@[eg_id],7,3))" ).append("\n"); 
		query.append("AND    (DECODE(V.SVC_CATE_CD,'TR','Y','Y','N') =  DECODE(SVC_CATE_TRSP_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(V.SVC_CATE_CD,'RL','Y','Y','N') =  DECODE(S.SVC_CATE_RAIL_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(V.SVC_CATE_CD,'CY','Y','Y','N') =  DECODE(S.SVC_CATE_CY_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(V.SVC_CATE_CD,'TM','Y','Y','N') =  DECODE(S.SVC_CATE_TML_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(V.SVC_CATE_CD,'WT','Y','Y','N') =  DECODE(S.SVC_CATE_WTR_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(V.SVC_CATE_CD,'EQ','Y','Y','N') =  DECODE(S.SVC_CATE_EQ_FLG,'Y','Y','X')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if(${eg_rhq_cd}!='')" ).append("\n"); 
		query.append("AND   C.EG_RHQ_CD = @[eg_rhq_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${eg_cty_cd}!='')" ).append("\n"); 
		query.append("AND	  C.EG_CTY_CD = UPPER(@[eg_cty_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${svc_cate_cd}!='')" ).append("\n"); 
		query.append("AND   C.SVC_CATE_CD = @[svc_cate_cd]" ).append("\n"); 
		query.append("AND   A.VNDR_SEQ IN (SELECT VNDR_SEQ" ).append("\n"); 
		query.append("FROM SPE_SVC_PROV_SVC_CATE_MTCH" ).append("\n"); 
		query.append("WHERE (DECODE(@[svc_cate_cd],'TR','Y','Y','N') =  DECODE(SVC_CATE_TRSP_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(@[svc_cate_cd],'RL','Y','Y','N') =  DECODE(SVC_CATE_RAIL_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(@[svc_cate_cd],'CY','Y','Y','N') =  DECODE(SVC_CATE_CY_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(@[svc_cate_cd],'TM','Y','Y','N') =  DECODE(SVC_CATE_TML_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(@[svc_cate_cd],'WT','Y','Y','N') =  DECODE(SVC_CATE_WTR_FLG,'Y','Y','X')" ).append("\n"); 
		query.append("OR DECODE(@[svc_cate_cd],'EQ','Y','Y','N') =  DECODE(SVC_CATE_EQ_FLG,'Y','Y','X')" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}