/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGuidelineMainDBDAOChkGlEffDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 박성수
*@LastVersion : 1.0
* 2009.07.16 박성수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sungsoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAGuidelineMainDBDAOChkGlEffDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기간이 유효한지 검색
	  * </pre>
	  */
	public RFAGuidelineMainDBDAOChkGlEffDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gline_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.integration").append("\n"); 
		query.append("FileName : RFAGuidelineMainDBDAOChkGlEffDtRSQL").append("\n"); 
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
		query.append("SELECT gline_seq" ).append("\n"); 
		query.append("FROM pri_rg_mn" ).append("\n"); 
		query.append("WHERE svc_scp_cd = @[svc_scp_cd]" ).append("\n"); 
		query.append("#if (${HAS_GLINE_SEQ} == 'Y')" ).append("\n"); 
		query.append("AND gline_seq <> @[gline_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${BACKUP} == 'Y')" ).append("\n"); 
		query.append("AND (to_char(eff_dt, 'YYYY-MM-DD') BETWEEN @[eff_dt] AND @[exp_dt]" ).append("\n"); 
		query.append("OR to_char(exp_dt, 'YYYY-MM-DD') BETWEEN @[eff_dt] AND @[exp_dt]" ).append("\n"); 
		query.append("OR (to_char(eff_dt, 'YYYY-MM-DD') <= @[eff_dt] AND to_char(exp_dt, 'YYYY-MM-DD') >= @[exp_dt]))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND to_char(eff_dt, 'YYYY-MM-DD') = @[eff_dt]" ).append("\n"); 

	}
}