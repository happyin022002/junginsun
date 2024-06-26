/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchVesselListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.12.30 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoon, Seyeong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchVesselListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선박명 조회 팝업
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchVesselListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchVesselListVORSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD, A.VSL_ENG_NM, 'OTHR' TOV, A.VSL_OWN_IND_CD, TO_CHAR(A.LNCH_DT,'YYYYMMDD') LNCH_DT," ).append("\n"); 
		query.append("A.VSL_RGST_CNT_CD, MC.CNT_NM, A.GRS_RGST_TONG_WGT, B.CRR_NM" ).append("\n"); 
		query.append("FROM   MDM_COUNTRY MC, MDM_CARRIER B, MDM_VSL_BLK A" ).append("\n"); 
		query.append("WHERE  MC.CNT_CD(+)		= A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("AND    B.CRR_CD(+)	 	= A.BLK_CRR_TP_CD" ).append("\n"); 
		query.append("AND    A.VSL_CD   		LIKE '%'||@[vsl_cd]||'%'" ).append("\n"); 
		query.append("AND    A.VSL_ENG_NM   	LIKE '%'||@[vsl_eng_nm]||'%'" ).append("\n"); 
		query.append("AND    A.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.VSL_CD, A.VSL_ENG_NM, 'CNTR' TOV, A.VSL_OWN_IND_CD, TO_CHAR(A.VSL_LNCH_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("A.VSL_RGST_CNT_CD, MC.CNT_NM, A.GRS_RGST_TONG_WGT, B.CRR_NM" ).append("\n"); 
		query.append("FROM   MDM_COUNTRY MC, MDM_CARRIER B, MDM_VSL_CNTR A" ).append("\n"); 
		query.append("WHERE  MC.CNT_CD		= A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("AND    B.CRR_CD		 	= A.CRR_CD" ).append("\n"); 
		query.append("AND	   A.VSL_CD   		LIKE '%'||@[vsl_cd]||'%'" ).append("\n"); 
		query.append("AND    A.VSL_ENG_NM   	LIKE '%'||@[vsl_eng_nm]||'%'" ).append("\n"); 
		query.append("AND    A.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("ORDER BY 1" ).append("\n"); 

	}
}