/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EvaluationGroupTerminalKpiManageDBDAOSearchVndrSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.01
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2010.02.01 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author NAMKOONG Jin Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EvaluationGroupTerminalKpiManageDBDAOSearchVndrSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 조건에서 입력 한 Vendor의 Name 조회
	  * </pre>
	  */
	public EvaluationGroupTerminalKpiManageDBDAOSearchVndrSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration").append("\n"); 
		query.append("FileName : EvaluationGroupTerminalKpiManageDBDAOSearchVndrSeqRSQL").append("\n"); 
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
		query.append("SELECT UPPER(@[yd_cd]) YD_CD," ).append("\n"); 
		query.append("LPAD(VNDR_SEQ, 6, '0') AS VNDR_SEQ," ).append("\n"); 
		query.append("VNDR_LGL_ENG_NM AS VNDR_ABBR_NM" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL(DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("AND VNDR_SEQ = TO_NUMBER(@[vndr_seq])" ).append("\n"); 

	}
}