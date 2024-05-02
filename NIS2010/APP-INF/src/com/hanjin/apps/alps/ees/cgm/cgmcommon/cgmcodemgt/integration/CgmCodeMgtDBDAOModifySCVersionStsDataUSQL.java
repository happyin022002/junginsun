/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmCodeMgtDBDAOModifySCVersionStsDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.04
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2016.04.04 박정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Min Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmCodeMgtDBDAOModifySCVersionStsDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * 2014-04-04 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청 - Amend 완료후 최종 입력된 Effective Date(Filed Date), Expire Date 에 맞게 이전 Version의 Chassis S/C Exception Version 의 Expire Date를 변경하는 로직 추가
	  * ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	  * </pre>
	  */
	public CgmCodeMgtDBDAOModifySCVersionStsDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_expt_ver_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ft_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration").append("\n"); 
		query.append("FileName : CgmCodeMgtDBDAOModifySCVersionStsDataUSQL").append("\n"); 
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
		query.append("UPDATE	CGM_SC_EXPT_VER A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SET		A.CHSS_EXPT_VER_STS_CD = @[chss_expt_ver_sts_cd]" ).append("\n"); 
		query.append("  ,     A.FT_FLG               = @[ft_flg]" ).append("\n"); 
		query.append("#if(${chss_expt_ver_sts_cd} == 'L')" ).append("\n"); 
		query.append(",   A.EFF_DT = (SELECT " ).append("\n"); 
		query.append("						SP.EFF_DT" ).append("\n"); 
		query.append("						FROM	PRI_SP_MN SP" ).append("\n"); 
		query.append("					   WHERE	SP.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("						 AND    SP.AMDT_SEQ = (" ).append("\n"); 
		query.append("											SELECT	/*+ INDEX_DESC(PRI_SP_MN XPKPRI_SP_MN) */ AMDT_SEQ" ).append("\n"); 
		query.append("											  FROM	PRI_SP_MN" ).append("\n"); 
		query.append("											 WHERE	PROP_NO = SP.PROP_NO" ).append("\n"); 
		query.append("											   AND	ROWNUM = 1" ).append("\n"); 
		query.append("											))" ).append("\n"); 
		query.append(",   A.EXP_DT = (SELECT " ).append("\n"); 
		query.append("						SP.EXP_DT" ).append("\n"); 
		query.append("						FROM	PRI_SP_MN SP" ).append("\n"); 
		query.append("					   WHERE	SP.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("						 AND    SP.AMDT_SEQ = (" ).append("\n"); 
		query.append("											SELECT	/*+ INDEX_DESC(PRI_SP_MN XPKPRI_SP_MN) */ AMDT_SEQ" ).append("\n"); 
		query.append("											  FROM	PRI_SP_MN" ).append("\n"); 
		query.append("											 WHERE	PROP_NO = SP.PROP_NO" ).append("\n"); 
		query.append("											   AND	ROWNUM = 1" ).append("\n"); 
		query.append("											))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if(${chss_expt_ver_sts_cd} == 'T')" ).append("\n"); 
		query.append(",	A.EFF_DT = TO_DATE(@[eff_dt], 'YYYY-MM-DD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	,	A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("	,	A.UPD_DT = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]), SYSDATE)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("#if(${sc_expt_ver_seq} != '')" ).append("\n"); 
		query.append("	AND	A.SC_EXPT_VER_SEQ = @[sc_expt_ver_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	AND" ).append("\n"); 
		query.append("		A.SC_EXPT_VER_SEQ = " ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT	/*+ INDEX_DESC(CGM_SC_EXPT_VER XPKCGM_SC_EXPT_VER) */ SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("			FROM	CGM_SC_EXPT_VER" ).append("\n"); 
		query.append("			WHERE	PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("			AND	ROWNUM = 1" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}