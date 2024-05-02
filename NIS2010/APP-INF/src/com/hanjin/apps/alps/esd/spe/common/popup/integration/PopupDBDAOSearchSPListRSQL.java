/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PopupDBDAOSearchSPListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.27
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.27 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.common.popup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author HI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PopupDBDAOSearchSPListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Service Provider 를 조회한다
	  * </pre>
	  */
	public PopupDBDAOSearchSPListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_svc_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pts_vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_eg_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_nm_eng",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_ev_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.spe.common.popup.integration").append("\n"); 
		query.append("FileName : PopupDBDAOSearchSPListRSQL").append("\n"); 
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
		query.append("#if (${search_type} == 'A')" ).append("\n"); 
		query.append("	SELECT DISTINCT VNDR_SEQ" ).append("\n"); 
		query.append("	     , OFC_CD" ).append("\n"); 
		query.append("	     , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	     , VNDR_ABBR_NM" ).append("\n"); 
		query.append("	     , PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("	     , VNDR_CNT_CD" ).append("\n"); 
		query.append("	     , ORG_VNDR_SEQ" ).append("\n"); 
		query.append("	     , ENG_ADDR" ).append("\n"); 
		query.append("	     , EV_SVC_CATE_CD" ).append("\n"); 
		query.append("	     , EG_ID" ).append("\n"); 
		query.append("	     , EG_NM" ).append("\n"); 
		query.append("	FROM (SELECT ROW_NUMBER() OVER (ORDER BY A.VNDR_SEQ) NO" ).append("\n"); 
		query.append("		       , LPAD(A.VNDR_SEQ, 6, '0') VNDR_SEQ" ).append("\n"); 
		query.append("		       , A.OFC_CD" ).append("\n"); 
		query.append("		       , A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("    		   , A.VNDR_ABBR_NM" ).append("\n"); 
		query.append("    		   , LPAD(A.PRNT_VNDR_SEQ, 6, '0') PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("    		   , A.VNDR_CNT_CD" ).append("\n"); 
		query.append("    		   , A.VNDR_CNT_CD||LPAD(VNDR_SEQ, 6, '0') ORG_VNDR_SEQ" ).append("\n"); 
		query.append("    		   , A.ENG_ADDR" ).append("\n"); 
		query.append("    		   , '' AS EV_SVC_CATE_CD" ).append("\n"); 
		query.append("    		   , B.EG_ID" ).append("\n"); 
		query.append("    		   , C.EG_NM" ).append("\n"); 
		query.append("	        FROM MDM_VENDOR A" ).append("\n"); 
		query.append("		       , SPE_SP_BZC_EV_GRP B " ).append("\n"); 
		query.append("               , SPE_EV_GRP C   " ).append("\n"); 
		query.append("	       WHERE A.VNDR_SEQ = B.SP_SEQ" ).append("\n"); 
		query.append("             AND B.EG_ID = C.EG_ID" ).append("\n"); 
		query.append("             AND EV_YR = @[s_ev_yr]" ).append("\n"); 
		query.append("	         AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("             " ).append("\n"); 
		query.append("	#if (${s_eg_rhq_cd} != '')" ).append("\n"); 
		query.append("		 AND C.EG_RHQ_CD = @[s_eg_rhq_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_eg_ofc_cd} != '')" ).append("\n"); 
		query.append("		 AND C.EG_OFC_CD = @[s_eg_ofc_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${s_ev_svc_cate_cd} != '')" ).append("\n"); 
		query.append("		 AND C.EV_SVC_CATE_CD = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${eg_id} != '')" ).append("\n"); 
		query.append("		 AND C.eg_id = @[eg_id]" ).append("\n"); 
		query.append("	#end        " ).append("\n"); 
		query.append("	#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("		 AND UPPER(VNDR_CNT_CD) like UPPER(@[cnt_cd]) || '%'" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("		 AND UPPER(OFC_CD) like UPPER(@[ofc_cd]) || '%'" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if (${vndr_nm_eng} != '')" ).append("\n"); 
		query.append("		 AND UPPER(VNDR_LGL_ENG_NM) like '%' || UPPER(@[vndr_nm_eng]) || '%'" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if (${pts_vndr_cd} != '')" ).append("\n"); 
		query.append("		 AND LPAD(PRNT_VNDR_SEQ, 6, '0') = LPAD(@[pts_vndr_cd], 6, '0')" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if (${vndr_cd} != '')" ).append("\n"); 
		query.append("		 AND LPAD(VNDR_SEQ, 6, '0') = LPAD(@[vndr_cd], 6, '0')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${lgs_flg} == 'Y')" ).append("\n"); 
		query.append("		AND LGS_FLG = 'Y'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	  )" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	SELECT VNDR_SEQ" ).append("\n"); 
		query.append("	     , OFC_CD" ).append("\n"); 
		query.append("	     , VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("	     , VNDR_ABBR_NM" ).append("\n"); 
		query.append("	     , PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("	     , VNDR_CNT_CD" ).append("\n"); 
		query.append("	     , ORG_VNDR_SEQ" ).append("\n"); 
		query.append("	     , ENG_ADDR" ).append("\n"); 
		query.append("	     , EV_SVC_CATE_CD" ).append("\n"); 
		query.append("	FROM (SELECT ROW_NUMBER() OVER (ORDER BY A.VNDR_SEQ) NO" ).append("\n"); 
		query.append("		   , LPAD(A.VNDR_SEQ, 6, '0') VNDR_SEQ" ).append("\n"); 
		query.append("		   , A.OFC_CD" ).append("\n"); 
		query.append("		   , A.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append("		   , A.VNDR_ABBR_NM" ).append("\n"); 
		query.append("		   , LPAD(A.PRNT_VNDR_SEQ, 6, '0') PRNT_VNDR_SEQ" ).append("\n"); 
		query.append("		   , A.VNDR_CNT_CD" ).append("\n"); 
		query.append("		   , A.VNDR_CNT_CD||LPAD(VNDR_SEQ, 6, '0') ORG_VNDR_SEQ" ).append("\n"); 
		query.append("		   , A.ENG_ADDR" ).append("\n"); 
		query.append("		   , B.EV_SVC_CATE_CD" ).append("\n"); 
		query.append("		FROM MDM_VENDOR A" ).append("\n"); 
		query.append("		   , SPE_SP_SVC_CATE_STUP B     " ).append("\n"); 
		query.append("	       WHERE A.VNDR_SEQ = B.SP_SEQ" ).append("\n"); 
		query.append("		 AND NVL(A.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${s_ev_svc_cate_cd} != '')" ).append("\n"); 
		query.append("		 AND B.EV_SVC_CATE_CD = @[s_ev_svc_cate_cd]" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if (${cnt_cd} != '')" ).append("\n"); 
		query.append("		 AND UPPER(VNDR_CNT_CD) like UPPER(@[cnt_cd]) || '%'" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if (${ofc_cd} != '')" ).append("\n"); 
		query.append("		 AND UPPER(OFC_CD) like UPPER(@[ofc_cd]) || '%'" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if (${vndr_nm_eng} != '')" ).append("\n"); 
		query.append("		 AND UPPER(VNDR_LGL_ENG_NM) like '%' || UPPER(@[vndr_nm_eng]) || '%'" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if (${pts_vndr_cd} != '')" ).append("\n"); 
		query.append("		 AND LPAD(PRNT_VNDR_SEQ, 6, '0') = LPAD(@[pts_vndr_cd], 6, '0')" ).append("\n"); 
		query.append("	#end    " ).append("\n"); 
		query.append("	#if (${vndr_cd} != '')" ).append("\n"); 
		query.append("		 AND LPAD(VNDR_SEQ, 6, '0') = LPAD(@[vndr_cd], 6, '0')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	#if (${lgs_flg} == 'Y')" ).append("\n"); 
		query.append("		AND LGS_FLG = 'Y'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	  )" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}