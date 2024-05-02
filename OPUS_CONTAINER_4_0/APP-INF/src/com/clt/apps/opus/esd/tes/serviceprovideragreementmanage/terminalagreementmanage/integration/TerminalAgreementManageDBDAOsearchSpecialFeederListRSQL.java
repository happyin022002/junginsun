/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOsearchSpecialFeederListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.04.27 조정민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOsearchSpecialFeederListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * China Special Feeder화면 조회
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOsearchSpecialFeederListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOsearchSpecialFeederListRSQL").append("\n"); 
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
		query.append("SELECT F.FDR_POL_CD, L.LOC_NM POL_LOC_NM, F.FDR_POD_CD, M.LOC_NM POD_LOC_NM" ).append("\n"); 
		query.append("FROM TES_TML_SPCL_FDR F, MDM_LOCATION L, MDM_LOCATION M" ).append("\n"); 
		query.append("WHERE F.FDR_POL_CD = L.LOC_CD" ).append("\n"); 
		query.append("AND F.FDR_POD_CD = M.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pol_cd}!='')" ).append("\n"); 
		query.append("    AND FDR_POL_CD LIKE '%'||@[pol_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd}!='')" ).append("\n"); 
		query.append("    AND FDR_POD_CD LIKE '%'||@[pod_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY F.FDR_POL_CD,F.FDR_POD_CD" ).append("\n"); 

	}
}