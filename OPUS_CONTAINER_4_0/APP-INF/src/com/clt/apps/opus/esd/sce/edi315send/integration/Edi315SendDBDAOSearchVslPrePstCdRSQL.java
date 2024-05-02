/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendDBDAOSearchVslPrePstCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.27
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2016.04.27 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchVslPrePstCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * edi 315 VslPrePstCd check
	  * </pre>
	  */
	public Edi315SendDBDAOSearchVslPrePstCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchVslPrePstCdRSQL").append("\n"); 
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
		query.append("SELECT 	COUNT(VVD.VSL_PRE_PST_CD)" ).append("\n"); 
		query.append("  FROM 	BKG_VVD VVD" ).append("\n"); 
		query.append(" WHERE  VVD.BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKPC')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LP') " ).append("\n"); 
		query.append(" --   AND  SCD.ACT_CD IN ('FLWMLO','FLVMLO') " ).append("\n"); 
		query.append("	AND  VVD.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'DP')" ).append("\n"); 
		query.append("--    AND  SCD.ACT_CD in ('FTWMUD','FTVMUD','FUWMUD') " ).append("\n"); 
		query.append("	AND  VVD.VSL_PRE_PST_CD = 'S'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKMC')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LP') " ).append("\n"); 
		query.append("--	AND SCD. ACT_CD in ('FTVMLO','FLVMLO')" ).append("\n"); 
		query.append("	AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'DP') " ).append("\n"); 
		query.append("--	AND SCD.ACT_CD = 'FTVMUD'" ).append("\n"); 
		query.append("	AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${trans_tp_cd} == 'TRNKOC')" ).append("\n"); 
		query.append("	#if (${loc_tp_cd} == 'LP') " ).append("\n"); 
		query.append("--	AND SCD.ACT_CD IN ('FLWMLO','FTVMLO')" ).append("\n"); 
		query.append("	AND  VVD.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("	#elseif(${loc_tp_cd} == 'DP') " ).append("\n"); 
		query.append("--	AND SCD.ACT_CD in ('FUWMUD','FUVMUD')" ).append("\n"); 
		query.append("	AND  VVD.VSL_PRE_PST_CD = 'U'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}