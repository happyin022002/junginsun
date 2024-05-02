/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExceptionDataDBDAOSearchExptDetailQueryStrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 이중환
*@LastVersion : 1.0
* 2009.10.14 이중환
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Joong Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExceptionDataDBDAOSearchExptDetailQueryStrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select querystr
	  * </pre>
	  */
	public ExceptionDataDBDAOSearchExptDetailQueryStrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cop_expt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_cop_expt_tp_dtl_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.integration").append("\n"); 
		query.append("FileName : ExceptionDataDBDAOSearchExptDetailQueryStrRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR(MIN(CUR_FMACT_CD),1,8) F_FM_EXPT_CD, SUBSTR(MIN(CUR_FMACT_CD),1,3)||'00000' F_COP_EXPT_TP_DTL_CD" ).append("\n"); 
		query.append(",(CASE WHEN COUNT(SUBSTR(CUR_FMACT_CD,1,8)) >= 2 AND SUBSTR(MIN(CUR_FMACT_CD),9,1) = 'N' AND SUBSTR(MAX(CUR_FMACT_CD),9,1) = 'Y'" ).append("\n"); 
		query.append("THEN 'Y' ELSE SUBSTR(MIN(CUR_FMACT_CD),9,1) END) F_VALIDATION, '' F_TO_EXPT_CD" ).append("\n"); 
		query.append("FROM   (SELECT (CASE WHEN FA.CHK_FMACT = 'Y' THEN MIN(FA.CHK_FMACT_NO)||FA.CHK_FMACT ELSE MAX(FA.CHK_FMACT_NO)||FA.CHK_FMACT END) CUR_FMACT_CD" ).append("\n"); 
		query.append("FROM   (SELECT  /* INPUT From Activity Code */" ).append("\n"); 
		query.append("(CASE WHEN SUBSTR(F.EXPT_CD,1,4) = D.CUR_DTL_CD || '1'" ).append("\n"); 
		query.append("THEN (CASE WHEN F.EXPT_CD_NM = @[f_cop_expt_tp_dtl_nm]  THEN 'Y' ELSE 'N' END) 		--'FTVMUD'" ).append("\n"); 
		query.append("ELSE 'N' END) CHK_FMACT" ).append("\n"); 
		query.append(",(CASE WHEN SUBSTR(F.EXPT_CD,1,4) = D.CUR_DTL_CD || '1'" ).append("\n"); 
		query.append("THEN (CASE WHEN F.EXPT_CD_NM = @[f_cop_expt_tp_dtl_nm] THEN MAX(F.EXPT_CD) ELSE MAX(TO_NUMBER(SUBSTR(F.EXPT_CD,1,6))+1)||'00' END) 		--'FTVMUD'" ).append("\n"); 
		query.append("ELSE D.CUR_DTL_CD || '10100' END) CHK_FMACT_NO" ).append("\n"); 
		query.append("FROM   SCE_EXPT_CD F," ).append("\n"); 
		query.append("(SELECT ( CASE WHEN MAX(SUBSTR(CHK_DTL_NM,9,1)) = 'Y'" ).append("\n"); 
		query.append("THEN SUBSTR(MIN(CHK_DTL_CD),1,3)" ).append("\n"); 
		query.append("ELSE SUBSTR(MAX(CHK_DTL_CD),1,3) END ) CUR_DTL_CD" ).append("\n"); 
		query.append("FROM  ( SELECT  --INPUT ExceptionTypeDeail Name" ).append("\n"); 
		query.append("(CASE WHEN DTP.EXPT_CD_NM = @[f_cop_expt_tp_dtl_nm] THEN 'Y' ELSE 'N' END) CHK_DTL_NM			--'ETD Delay Exception'" ).append("\n"); 
		query.append(",(CASE WHEN DTP.EXPT_CD_NM = @[f_cop_expt_tp_dtl_nm] THEN MAX(DTP.EXPT_CD)||'Y' ELSE MAX(TO_NUMBER(SUBSTR(DTP.EXPT_CD,1,3))+1)||'00000'||'N' END) CHK_DTL_CD		--'ETD Delay Exception'" ).append("\n"); 
		query.append("FROM ( SELECT EXPT_CD, SUBSTR(EXPT_CD,1,1) EXPT_TP_CD, SUBSTR(EXPT_CD,1,3) EXPT_TP_DTL_CD, EXPT_CD_NM" ).append("\n"); 
		query.append("FROM SCE_EXPT_CD" ).append("\n"); 
		query.append("WHERE EXPT_CD LIKE '%00000' AND ACT_FLG = 'Y' AND EXPT_CD NOT LIKE '%0000000' ) DTP" ).append("\n"); 
		query.append("WHERE DTP.EXPT_TP_CD = @[f_cop_expt_tp_cd]      --INPUT EXPT_TP 		--'2'" ).append("\n"); 
		query.append("GROUP BY DTP.EXPT_CD_NM  )" ).append("\n"); 
		query.append(") D" ).append("\n"); 
		query.append("WHERE  F.EXPT_CD NOT LIKE '%00000'" ).append("\n"); 
		query.append("AND    F.ACT_FLG = 'Y'" ).append("\n"); 
		query.append("AND    SUBSTR(F.EXPT_CD,1,1) = SUBSTR(D.CUR_DTL_CD,1,1)" ).append("\n"); 
		query.append("GROUP BY F.EXPT_CD, F.EXPT_CD_NM, D.CUR_DTL_CD) FA" ).append("\n"); 
		query.append("GROUP BY FA.CHK_FMACT )" ).append("\n"); 

	}
}