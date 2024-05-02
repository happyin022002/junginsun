/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DryWetClaimDBDAOSearchVesselVvdListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.14
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.03.14 이준범
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DryWetClaimDBDAOSearchVesselVvdListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선박 항차 정보를 조회한다
	  * </pre>
	  */
	public DryWetClaimDBDAOSearchVesselVvdListVORSQL(){
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.cps.cni.codemgt.codemgt.integration").append("\n"); 
		query.append("FileName : DryWetClaimDBDAOSearchVesselVvdListVORSQL").append("\n"); 
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
		query.append("SELECT A.VSL_CD, B.SKD_VOY_NO, B.SKD_DIR_CD, A.VSL_ENG_NM, 'CNTR' TOV," ).append("\n"); 
		query.append("	   A.VSL_OWN_IND_CD, B.VSL_SLAN_CD, TO_CHAR(A.VSL_LNCH_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("	   A.VSL_RGST_CNT_CD, MC.CNT_NM, CLSS_NO_RGST_AREA_NM, A.GRS_RGST_TONG_WGT, A.DWT_WGT SMR_DWT_WGT" ).append("\n"); 
		query.append("FROM   MDM_COUNTRY MC, VSK_VSL_SKD B, MDM_VSL_CNTR A" ).append("\n"); 
		query.append("WHERE  MC.CNT_CD		= A.VSL_RGST_CNT_CD" ).append("\n"); 
		query.append("AND    B.VSL_CD(+)		= A.VSL_CD" ).append("\n"); 
		query.append("AND    A.VSL_CD   		LIKE '%'||@[vsl_cd]||'%'" ).append("\n"); 
		query.append("AND    B.SKD_VOY_NO   	LIKE '%'||@[skd_voy_no]||'%'" ).append("\n"); 
		query.append("AND    B.SKD_DIR_CD   	LIKE '%'||@[skd_dir_cd]||'%'" ).append("\n"); 
		query.append("AND    A.VSL_ENG_NM   	LIKE '%'||@[vsl_eng_nm]||'%'" ).append("\n"); 
		query.append("AND    A.DELT_FLG 		= 'N'" ).append("\n"); 
		query.append("ORDER BY 1,2,3" ).append("\n"); 

	}
}