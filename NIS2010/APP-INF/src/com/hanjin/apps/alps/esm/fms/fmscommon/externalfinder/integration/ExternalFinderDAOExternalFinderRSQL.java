/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ExternalFinderDAOExternalFinderRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalFinderDAOExternalFinderRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExternalFinderDAOExternalFinderRSQL
	  * </pre>
	  */
	public ExternalFinderDAOExternalFinderRSQL(){
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
		params.put("fdr_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.integration").append("\n"); 
		query.append("FileName : ExternalFinderDAOExternalFinderRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX(MVC XPKMDM_VSL_CNTR) */" ).append("\n"); 
		query.append("    MVC.VSL_CD, " ).append("\n"); 
		query.append("	MVC.VSL_ENG_NM, " ).append("\n"); 
		query.append("	MVC.CRR_CD, " ).append("\n"); 
		query.append("	DECODE(MVC.FDR_DIV_CD, 'T', 'Truck', 'Off') FDR_DIV_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append("WHERE MVC.DELT_FLG = 'N'" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("AND MVC.VSL_CD LIKE @[vsl_cd] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vsl_eng_nm} != '') " ).append("\n"); 
		query.append("AND UPPER(MVC.VSL_ENG_NM) LIKE '%'||UPPER(@[vsl_eng_nm]) || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crr_cd} != '') " ).append("\n"); 
		query.append("AND MVC.CRR_CD = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${fdr_div_cd} != '') " ).append("\n"); 
		query.append("AND MVC.FDR_DIV_CD = @[fdr_div_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}