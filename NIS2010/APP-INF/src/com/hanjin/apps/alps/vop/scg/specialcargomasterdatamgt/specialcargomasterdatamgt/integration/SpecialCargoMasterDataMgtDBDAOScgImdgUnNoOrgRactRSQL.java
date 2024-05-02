/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAOScgImdgUnNoOrgRactRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.11
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.11.11 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoMasterDataMgtDBDAOScgImdgUnNoOrgRactRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public SpecialCargoMasterDataMgtDBDAOScgImdgUnNoOrgRactRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoMasterDataMgtDBDAOScgImdgUnNoOrgRactRSQL").append("\n"); 
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
		query.append("SELECT A.IMDG_UN_NO, A.IMDG_UN_NO_SEQ, A.IMDG_ORG_RACT_TP_CD,A.IMDG_TEC_NM," ).append("\n"); 
		query.append("A.IMDG_TEC_NM              ," ).append("\n"); 
		query.append("A.IMDG_CONC_RT_CTNT        ," ).append("\n"); 
		query.append("A.IMDG_PCK_MZD_CD          ," ).append("\n"); 
		query.append("A.IMDG_CTRL_TEMP           ," ).append("\n"); 
		query.append("A.IMDG_EMER_TEMP           ," ).append("\n"); 
		query.append("A.CRE_USR_ID               ," ).append("\n"); 
		query.append("A.CRE_DT                   ," ).append("\n"); 
		query.append("A.UPD_USR_ID               ," ).append("\n"); 
		query.append("A.UPD_DT                   ," ).append("\n"); 
		query.append("NVL(MAX(CASE  WHEN A.RN = 1 THEN A.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("NVL(MAX(CASE  WHEN A.RN = 2 THEN '/'||A.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("NVL(MAX(CASE  WHEN A.RN = 3 THEN '/'||A.IMDG_SUBS_RSK_LBL_CD  END),'')||" ).append("\n"); 
		query.append("NVL(MAX(CASE  WHEN A.RN = 4 THEN '/'||A.IMDG_SUBS_RSK_LBL_CD  END),'')  IMDG_SUBS_RSK_LBL_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.IMDG_UN_NO               ," ).append("\n"); 
		query.append("A.IMDG_UN_NO_SEQ           ," ).append("\n"); 
		query.append("CASE WHEN A.IMDG_ORG_RACT_TP_CD ='P' THEN  'Organic Peroxides'" ).append("\n"); 
		query.append("WHEN A.IMDG_ORG_RACT_TP_CD ='S' THEN  'Self-Reactive Substance'  END IMDG_ORG_RACT_TP_CD    ," ).append("\n"); 
		query.append("A.IMDG_TEC_NM              ," ).append("\n"); 
		query.append("A.IMDG_CONC_RT_CTNT        ," ).append("\n"); 
		query.append("A.IMDG_PCK_MZD_CD          ," ).append("\n"); 
		query.append("A.IMDG_CTRL_TEMP           ," ).append("\n"); 
		query.append("A.IMDG_EMER_TEMP           ," ).append("\n"); 
		query.append("A.CRE_USR_ID               ," ).append("\n"); 
		query.append("A.CRE_DT                   ," ).append("\n"); 
		query.append("A.UPD_USR_ID               ," ).append("\n"); 
		query.append("A.UPD_DT                   ," ).append("\n"); 
		query.append("B.IMDG_SUBS_RSK_LBL_CD," ).append("\n"); 
		query.append("(ROW_NUMBER()OVER(PARTITION BY A.IMDG_UN_NO,A.IMDG_UN_NO_SEQ ORDER BY  IMDG_SUBS_RSK_LBL_CD)) RN" ).append("\n"); 
		query.append("FROM SCG_IMDG_UN_NO_ORG_RACT A, SCG_IMDG_SUBS_RSK_LBL B" ).append("\n"); 
		query.append("WHERE  A.IMDG_UN_NO     = B.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("AND   A.IMDG_UN_NO_SEQ = B.IMDG_UN_NO_SEQ(+)" ).append("\n"); 
		query.append("AND   A.IMDG_ORG_RACT_TP_CD IN ('P','S')" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '')" ).append("\n"); 
		query.append("AND  A.IMDG_UN_NO =  @[imdg_un_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("GROUP BY A.IMDG_UN_NO, A.IMDG_UN_NO_SEQ, A.IMDG_ORG_RACT_TP_CD, A.IMDG_TEC_NM," ).append("\n"); 
		query.append("A.IMDG_TEC_NM              ," ).append("\n"); 
		query.append("A.IMDG_CONC_RT_CTNT        ," ).append("\n"); 
		query.append("A.IMDG_PCK_MZD_CD          ," ).append("\n"); 
		query.append("A.IMDG_CTRL_TEMP           ," ).append("\n"); 
		query.append("A.IMDG_EMER_TEMP           ," ).append("\n"); 
		query.append("A.CRE_USR_ID               ," ).append("\n"); 
		query.append("A.CRE_DT                   ," ).append("\n"); 
		query.append("A.UPD_USR_ID               ," ).append("\n"); 
		query.append("A.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY A.IMDG_UN_NO, A.IMDG_UN_NO_SEQ" ).append("\n"); 

	}
}