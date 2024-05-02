/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ProgramDAOProgramRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.program.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProgramDAOProgramRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select program list information
	  * </pre>
	  */
	public ProgramDAOProgramRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_mnu_div_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pgm_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.management.alps.program.integration").append("\n"); 
		query.append("FileName : ProgramDAOProgramRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append(" 	PGM_NO" ).append("\n"); 
		query.append("	,PGM_NM" ).append("\n"); 
		query.append("	,PGM_DESC" ).append("\n"); 
		query.append("	,PGM_URL" ).append("\n"); 
		query.append("	,ROLES" ).append("\n"); 
		query.append("	,OFCS" ).append("\n"); 
		query.append("	,USE_FLG" ).append("\n"); 
		query.append("	,PGM_USE_FLG" ).append("\n"); 
		query.append("	,PGM_MNU_DIV_CD" ).append("\n"); 
		query.append("	,PGM_TP_CD" ).append("\n"); 
		query.append("	,PGM_STS_CD" ).append("\n"); 
		query.append("	,DEV_NM" ).append("\n"); 
		query.append("	,DEV_DT" ).append("\n"); 
		query.append("	,POPUP_FLG" ).append("\n"); 
		query.append("	,JOBS" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		A.pgm_no, " ).append("\n"); 
		query.append("		A.pgm_nm, " ).append("\n"); 
		query.append("		A.pgm_desc, " ).append("\n"); 
		query.append("		A.pgm_url," ).append("\n"); 
		query.append("		DECODE(B.PGM_NO,NULL,'X',0,'X','O') ROLES, " ).append("\n"); 
		query.append("		DECODE(C.PGM_NO,NULL,'X',0,'X','O') OFCS, " ).append("\n"); 
		query.append("		DECODE(D.PGM_NO,NULL,'N',0,'N','Y') USE_FLG," ).append("\n"); 
		query.append("		A.USE_FLG AS PGM_USE_FLG," ).append("\n"); 
		query.append("		A.pgm_mnu_div_cd, " ).append("\n"); 
		query.append("		A.pgm_tp_cd, " ).append("\n"); 
		query.append("		A.pgm_sts_cd, " ).append("\n"); 
		query.append("		A.dev_nm," ).append("\n"); 
		query.append("		to_char(dev_dt, 'yyyymmdd') dev_dt, " ).append("\n"); 
		query.append("		A.popup_flg,  " ).append("\n"); 
		query.append("		DECODE(E.PGM_NO,NULL,'X',0,'X','O') JOBS" ).append("\n"); 
		query.append("	FROM com_program A, (SELECT DISTINCT C1.PGM_NO PGM_NO FROM COM_PGM_ROLE C1) B," ).append("\n"); 
		query.append("		(SELECT DISTINCT C1.PGM_NO PGM_NO FROM COM_OFC_PGM_MTCH C1) C," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("		SELECT DISTINCT PGM_NO" ).append("\n"); 
		query.append("		FROM" ).append("\n"); 
		query.append("			(" ).append("\n"); 
		query.append("			select A.PGM_NO" ).append("\n"); 
		query.append("			FROM COM_PROGRAM A , COM_MNU_CFG B" ).append("\n"); 
		query.append("			WHERE A.PGM_NO = B.PRNT_PGM_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			select A.PGM_NO" ).append("\n"); 
		query.append("			FROM COM_PROGRAM A , COM_MNU_CFG B" ).append("\n"); 
		query.append("			WHERE A.PGM_NO = B.CHD_PGM_NO" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		) D," ).append("\n"); 
		query.append("        (SELECT DISTINCT C1.PGM_NO PGM_NO FROM COM_PGM_ROLE C1) E" ).append("\n"); 
		query.append("	WHERE A.PGM_NO = B.PGM_NO(+)" ).append("\n"); 
		query.append("		AND A.PGM_NO = C.PGM_NO(+)" ).append("\n"); 
		query.append("		AND A.PGM_NO = D.PGM_NO(+)" ).append("\n"); 
		query.append("        AND A.PGM_NO = E.PGM_NO(+)" ).append("\n"); 
		query.append("		#if (${pgm_tp_cd} != '') " ).append("\n"); 
		query.append("		and	A.pgm_tp_cd = @[pgm_tp_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pgm_mnu_div_cd} != '') " ).append("\n"); 
		query.append("		and	A.pgm_mnu_div_cd = @[pgm_mnu_div_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pgm_no} != '') " ).append("\n"); 
		query.append("		and	A.pgm_no like '%'|| @[pgm_no] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pgm_nm} != '') " ).append("\n"); 
		query.append("		and	A.pgm_nm like '%'|| @[pgm_nm] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("#if (${pgm_use_flg} != '') " ).append("\n"); 
		query.append("WHERE use_flg like '%'|| @[pgm_use_flg] || '%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}