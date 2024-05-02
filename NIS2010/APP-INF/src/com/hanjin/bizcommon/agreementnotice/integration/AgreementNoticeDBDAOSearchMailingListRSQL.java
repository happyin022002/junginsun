/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AgreementNoticeDBDAOSearchMailingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.20
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementNoticeDBDAOSearchMailingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchMailingList
	  * </pre>
	  */
	public AgreementNoticeDBDAOSearchMailingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.bizcommon.agreementnotice.integration").append("\n"); 
		query.append("FileName : AgreementNoticeDBDAOSearchMailingListRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	XX.*" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${arr_usr_nm_list} != '' and $arr_usr_nm_list.size() > 0)" ).append("\n"); 
		query.append("	#foreach($arr_usr_nm IN ${arr_usr_nm_list})" ).append("\n"); 
		query.append("$arr_usr_nm" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	X.SYS_CD" ).append("\n"); 
		query.append("	, X.OFC_TP_CD" ).append("\n"); 
		query.append("	, X.CTRT_OFC_CD  " ).append("\n"); 
		query.append("	, DECODE(X.AGMT_NO,'ALL','',X.AGMT_NO) AS AGMT_NO" ).append("\n"); 
		query.append("	, X.AGMT_MAPG_NO" ).append("\n"); 
		query.append("	, X.ROOT_PGM_NO" ).append("\n"); 
		query.append("	, DECODE(X.AGMT_MAPG_NO,''" ).append("\n"); 
		query.append("	         ,(SELECT COUNT(DISTINCT INFO.CTRT_UPD_USR_ID) " ).append("\n"); 
		query.append("	           FROM COM_CTRT_NTC_INFO INFO " ).append("\n"); 
		query.append("	           WHERE INFO.SYS_CD = X.SYS_CD AND INFO.CTRT_OFC_CD = X.CTRT_OFC_CD)" ).append("\n"); 
		query.append("	         ,(SELECT COUNT(DISTINCT INFO.CTRT_UPD_USR_ID) " ).append("\n"); 
		query.append("	           FROM COM_CTRT_NTC_INFO INFO " ).append("\n"); 
		query.append("	           WHERE INFO.SYS_CD = X.SYS_CD " ).append("\n"); 
		query.append("	           AND INFO.AGMT_NO LIKE '%'||X.AGMT_MAPG_NO||'%' " ).append("\n"); 
		query.append("	           AND INFO.CTRT_OFC_CD = X.CTRT_OFC_CD)) AS CTRT_CRE_USR_COUNT" ).append("\n"); 
		query.append("	, X.CRE_USR_ID" ).append("\n"); 
		query.append("	, X.CRE_DT" ).append("\n"); 
		query.append("	, X.UPD_USR_ID" ).append("\n"); 
		query.append("	, X.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${arr_usr_id_list} != '' and $arr_usr_id_list.size() > 0)" ).append("\n"); 
		query.append("	#foreach($arr_usr_id IN ${arr_usr_id_list})" ).append("\n"); 
		query.append("$arr_usr_id" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${arr_usr_jc_list} != '' and $arr_usr_jc_list.size() > 0)" ).append("\n"); 
		query.append("	#foreach($arr_usr_jc IN ${arr_usr_jc_list})" ).append("\n"); 
		query.append("$arr_usr_jc" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		L.NTC_USR_SEQ, L.NTC_USR_ID, L.NTC_USR_ID_JB_CD" ).append("\n"); 
		query.append("		, M.SYS_CD, M.CTRT_OFC_CD, M.OFC_TP_CD, M.AGMT_NO, M.AGMT_MAPG_NO, M.ROOT_PGM_NO, M.EML_SND_FLG, M.EML_SND_DT" ).append("\n"); 
		query.append("		, M.NTC_USR_ID_LIST_CTNT, M.NTC_USR_ID_JB_CD_LIST_CTNT, M.CRE_USR_ID, M.CRE_DT, M.UPD_USR_ID, M.UPD_DT" ).append("\n"); 
		query.append("	FROM COM_CTRT_USR_MGMT M, COM_CTRT_USR_LIST L" ).append("\n"); 
		query.append("	WHERE 1=1" ).append("\n"); 
		query.append("		AND M.SYS_CD = L.SYS_CD(+)" ).append("\n"); 
		query.append("		AND M.SYS_CD = @[sys_cd]" ).append("\n"); 
		query.append("#if(${ofc_tp_cd} != 'ALL')" ).append("\n"); 
		query.append("		AND M.OFC_TP_CD = @[ofc_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		AND M.CTRT_OFC_CD = L.CTRT_OFC_CD(+)" ).append("\n"); 
		query.append("		AND M.AGMT_NO = L.AGMT_NO(+)" ).append("\n"); 
		query.append("	GROUP BY M.SYS_CD, M.CTRT_OFC_CD, M.OFC_TP_CD, M.AGMT_NO, M.AGMT_MAPG_NO, M.ROOT_PGM_NO, M.EML_SND_FLG, M.EML_SND_DT" ).append("\n"); 
		query.append("			, M.NTC_USR_ID_LIST_CTNT, M.NTC_USR_ID_JB_CD_LIST_CTNT, M.CRE_USR_ID, M.CRE_DT, M.UPD_USR_ID, M.UPD_DT" ).append("\n"); 
		query.append("    	    , L.NTC_USR_SEQ, L.NTC_USR_ID, L.NTC_USR_ID_JB_CD" ).append("\n"); 
		query.append("	) X" ).append("\n"); 
		query.append("GROUP BY X.SYS_CD, X.CTRT_OFC_CD, X.OFC_TP_CD, X.AGMT_NO, X.AGMT_MAPG_NO, X.ROOT_PGM_NO, X.EML_SND_FLG, X.EML_SND_DT" ).append("\n"); 
		query.append("		, X.NTC_USR_ID_LIST_CTNT, X.NTC_USR_ID_JB_CD_LIST_CTNT, X.CRE_USR_ID, X.CRE_DT, X.UPD_USR_ID, X.UPD_DT" ).append("\n"); 
		query.append("ORDER BY X.SYS_CD, X.CTRT_OFC_CD, X.AGMT_NO" ).append("\n"); 
		query.append(") XX" ).append("\n"); 
		query.append("--WHERE ROWNUM <= 4" ).append("\n"); 

	}
}