/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RocsManifestListDownloadDBDAOsearchRocsReceiveListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RocsManifestListDownloadDBDAOsearchRocsReceiveListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI 현황
	  * </pre>
	  */
	public RocsManifestListDownloadDBDAOsearchRocsReceiveListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_start_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("totime",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromtime",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.integration").append("\n"); 
		query.append("FileName : RocsManifestListDownloadDBDAOsearchRocsReceiveListRSQL").append("\n"); 
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
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("SELECT	DECODE(A.RTM_EDI_MSG_TP_CD,'A','ACCEPT','R','REJECT') RTM_EDI_MSG_TP_CD," ).append("\n"); 
		query.append("		A.MSG_SND_DT," ).append("\n"); 
		query.append("		A.BL_NO," ).append("\n"); 
		query.append("		A.RTM_EDI_ERR_ID," ).append("\n"); 
		query.append("		A.ERR_DESC," ).append("\n"); 
		query.append("		A.ERR_CTNT," ).append("\n"); 
		query.append("		A.OFC_CD," ).append("\n"); 
		query.append("		A.CRE_USR_ID," ).append("\n"); 
		query.append("		B.ROWCNT," ).append("\n"); 
		query.append("		C.VVD VVD_NUMBER," ).append("\n"); 
		query.append("		C.POL_CD," ).append("\n"); 
		query.append("		C.POD_CD," ).append("\n"); 
		query.append("		'C' HIST," ).append("\n"); 
		query.append("		RBL.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_RTM_EDI_LOG A," ).append("\n"); 
		query.append("		( SELECT MAX ( MSG_SND_DT ) MAX_MSG_DT," ).append("\n"); 
		query.append("				BL_NO," ).append("\n"); 
		query.append("				COUNT ( RTM_EDI_MSG_TP_CD ) ROWCNT" ).append("\n"); 
		query.append("			FROM BKG_CSTMS_RTM_EDI_LOG" ).append("\n"); 
		query.append("		   WHERE RCV_SND_DIV_CD = 'R'" ).append("\n"); 
		query.append("     		 GROUP BY BL_NO                       )  B," ).append("\n"); 
		query.append("		( SELECT " ).append("\n"); 
		query.append("			DISTINCT D.BL_NO BL_NO," ).append("\n"); 
		query.append("			D.MSG_SND_DT MAX_MSG_DT," ).append("\n"); 
		query.append("			D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("			D.POL_CD POL_CD," ).append("\n"); 
		query.append("			D.POD_CD POD_CD" ).append("\n"); 
		query.append("			FROM BKG_CSTMS_RTM_EDI_LOG D, " ).append("\n"); 
		query.append("				(SELECT MAX(MSG_SND_DT) MAX_MSG_DT, BL_NO " ).append("\n"); 
		query.append("				FROM BKG_CSTMS_RTM_EDI_LOG " ).append("\n"); 
		query.append("				WHERE RCV_SND_DIV_CD = 'S'" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("				AND   VSL_CD	=	@[vsl_cd]" ).append("\n"); 
		query.append("				AND   SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("				AND   SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("				GROUP BY BL_NO) E" ).append("\n"); 
		query.append("			WHERE RCV_SND_DIV_CD = 'S'" ).append("\n"); 
		query.append("			AND D.BL_NO = E.BL_NO" ).append("\n"); 
		query.append("			AND D.MSG_SND_DT = E.MAX_MSG_DT" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("			AND    D.VSL_CD	=	@[vsl_cd]" ).append("\n"); 
		query.append("			AND    D.SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("			AND    D.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no}!= '')" ).append("\n"); 
		query.append("       		AND D.BL_NO	=	@[bl_no]" ).append("\n"); 
		query.append("#end							   " ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("			AND	D.POL_CD	=	@[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd}!= '' )" ).append("\n"); 
		query.append("			AND	D.POD_CD	=	@[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			GROUP BY D.MSG_SND_DT, D.BL_NO, D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD, D.POL_CD, D.POD_CD" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append(", BKG_CSTMS_RTM_BL RBL" ).append("\n"); 
		query.append("WHERE	A.RCV_SND_DIV_CD = 'R' " ).append("\n"); 
		query.append("#if (${msg_type}!= '')" ).append("\n"); 
		query.append("	AND  RTM_EDI_MSG_TP_CD	=	@[msg_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND A.MSG_SND_DT = B.MAX_MSG_DT" ).append("\n"); 
		query.append("	AND	A.BL_NO	= B.BL_NO" ).append("\n"); 
		query.append("	AND	A.BL_NO = C.BL_NO" ).append("\n"); 
		query.append("	AND A.BL_NO = RBL.BL_NO" ).append("\n"); 
		query.append("	#if ( ${pod_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("	AND RBL.POD_CLPT_IND_SEQ = @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("ORDER BY A.RTM_EDI_MSG_TP_CD, A.BL_NO, A.MSG_SND_DT" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT	DECODE(A.RTM_EDI_MSG_TP_CD,'A','ACCEPT','R','REJECT') RTM_EDI_MSG_TP_CD," ).append("\n"); 
		query.append("		A.MSG_SND_DT," ).append("\n"); 
		query.append("		A.BL_NO," ).append("\n"); 
		query.append("		A.RTM_EDI_ERR_ID," ).append("\n"); 
		query.append("		A.ERR_DESC," ).append("\n"); 
		query.append("		A.ERR_CTNT," ).append("\n"); 
		query.append("		A.OFC_CD," ).append("\n"); 
		query.append("		A.CRE_USR_ID," ).append("\n"); 
		query.append("		B.ROWCNT," ).append("\n"); 
		query.append("		C.VVD VVD_NUMBER," ).append("\n"); 
		query.append("		C.POL_CD," ).append("\n"); 
		query.append("		C.POD_CD," ).append("\n"); 
		query.append("		'C' HIST," ).append("\n"); 
		query.append("		RBL.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_RTM_EDI_LOG A," ).append("\n"); 
		query.append("		( SELECT MAX ( MSG_SND_DT ) MAX_MSG_DT," ).append("\n"); 
		query.append("				BL_NO," ).append("\n"); 
		query.append("				COUNT ( RTM_EDI_MSG_TP_CD ) ROWCNT" ).append("\n"); 
		query.append("			FROM BKG_CSTMS_RTM_EDI_LOG" ).append("\n"); 
		query.append("		   WHERE RCV_SND_DIV_CD = 'R'" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("			 AND VSL_CD	=	@[vsl_cd]" ).append("\n"); 
		query.append("			 AND SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("			 AND SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("#if (${msg_type}!= '')" ).append("\n"); 
		query.append("       		 AND RTM_EDI_MSG_TP_CD	=	@[msg_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no}!= '')" ).append("\n"); 
		query.append("       		 AND BL_NO	=	@[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_eta_start_dt}!= '' && ${date_gubun}== '2')     	        " ).append("\n"); 
		query.append("        	 AND MSG_SND_DT >= TO_DATE(REPLACE(REPLACE(@[vps_eta_start_dt], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[fromtime], ':', '')||'00', '-',''),'YYYYMMDDHH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vps_eta_end_dt}!= '' && ${date_gubun}== '2')		  " ).append("\n"); 
		query.append("         	 AND MSG_SND_DT <= TO_DATE(REPLACE(REPLACE(@[vps_eta_end_dt], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[totime], ':', '')||'59', '-',''),'YYYYMMDDHH24:MI:SS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     		 GROUP BY BL_NO                       )  B," ).append("\n"); 
		query.append("		( SELECT " ).append("\n"); 
		query.append("			DISTINCT D.BL_NO BL_NO," ).append("\n"); 
		query.append("			D.MSG_SND_DT MAX_MSG_DT," ).append("\n"); 
		query.append("			D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("			D.POL_CD POL_CD," ).append("\n"); 
		query.append("			D.POD_CD POD_CD" ).append("\n"); 
		query.append("			FROM BKG_CSTMS_RTM_EDI_LOG D, " ).append("\n"); 
		query.append("				(SELECT MAX(MSG_SND_DT) MAX_MSG_DT, BL_NO " ).append("\n"); 
		query.append("				FROM BKG_CSTMS_RTM_EDI_LOG " ).append("\n"); 
		query.append("				WHERE RCV_SND_DIV_CD = 'S'" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("				AND   VSL_CD	=	@[vsl_cd]" ).append("\n"); 
		query.append("				AND   SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("				AND   SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("				GROUP BY BL_NO) E" ).append("\n"); 
		query.append("			WHERE RCV_SND_DIV_CD = 'S'" ).append("\n"); 
		query.append("			AND D.BL_NO = E.BL_NO" ).append("\n"); 
		query.append("			AND D.MSG_SND_DT = E.MAX_MSG_DT" ).append("\n"); 
		query.append("#if (${vsl_cd}!= '')" ).append("\n"); 
		query.append("			AND    D.VSL_CD	=	@[vsl_cd]" ).append("\n"); 
		query.append("			AND    D.SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("			AND    D.SKD_DIR_CD   = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("							   " ).append("\n"); 
		query.append("#if (${pol_cd}!= '')" ).append("\n"); 
		query.append("			AND	D.POL_CD	=	@[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${pod_cd}!= '' )" ).append("\n"); 
		query.append("			AND	D.POD_CD	=	@[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("			GROUP BY D.MSG_SND_DT, D.BL_NO, D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD, D.POL_CD, D.POD_CD" ).append("\n"); 
		query.append(") C" ).append("\n"); 
		query.append(", BKG_CSTMS_RTM_BL RBL" ).append("\n"); 
		query.append("WHERE	A.RCV_SND_DIV_CD = 'R' " ).append("\n"); 
		query.append("#if (${msg_type}!= '')" ).append("\n"); 
		query.append("	AND  RTM_EDI_MSG_TP_CD	=	@[msg_type]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	AND A.MSG_SND_DT = B.MAX_MSG_DT" ).append("\n"); 
		query.append("	AND	A.BL_NO	= B.BL_NO" ).append("\n"); 
		query.append("	AND	A.BL_NO	= C.BL_NO(+)" ).append("\n"); 
		query.append("	AND A.BL_NO = RBL.BL_NO" ).append("\n"); 
		query.append("	#if (${pod_clpt_ind_seq} != '')" ).append("\n"); 
		query.append("	AND RBL.POD_CLPT_IND_SEQ = @[pod_clpt_ind_seq]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("ORDER BY A.RTM_EDI_MSG_TP_CD, A.BL_NO, A.MSG_SND_DT" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}