/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GEMMasterCodeMgtDBDAOSearchDividedOfficeInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.06.08 진윤오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author J.Y.O
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GEMMasterCodeMgtDBDAOSearchDividedOfficeInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 비용실적에 대한 재분배를 위한 예외사항 정보
	  * </pre>
	  */
	public GEMMasterCodeMgtDBDAOSearchDividedOfficeInfoRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_expn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT OFC_CD," ).append("\n"); 
		query.append("ACCT_CD," ).append("\n"); 
		query.append("SPRT_GEN_EXPN_CD," ).append("\n"); 
		query.append("SPRT_YRMON," ).append("\n"); 
		query.append("UPD_USR_ID CRE_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(UPD_DT,'YYYY-MM-DD') CRE_DT," ).append("\n"); 
		query.append("DELT_FLG" ).append("\n"); 
		query.append("FROM   GEM_ACCT_EXPT" ).append("\n"); 
		query.append("WHERE  GEN_EXPN_CD = @[gen_expn_cd]" ).append("\n"); 
		query.append("AND DELT_FLG = @[delt_flg]" ).append("\n"); 
		query.append("order by OFC_CD , ACCT_CD , SPRT_GEN_EXPN_CD ,SPRT_YRMON" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.cps.gem.gemcommon.gemmastercodemgt.integration").append("\n"); 
		query.append("FileName : GEMMasterCodeMgtDBDAOSearchDividedOfficeInfoRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}