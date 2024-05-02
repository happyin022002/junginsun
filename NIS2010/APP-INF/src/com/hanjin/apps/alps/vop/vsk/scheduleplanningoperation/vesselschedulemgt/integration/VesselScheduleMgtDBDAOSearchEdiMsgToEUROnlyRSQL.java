/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselScheduleMgtDBDAOSearchEdiMsgToEUROnlyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.05
*@LastModifier : 
*@LastVersion : 1.0
* 2014.02.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMgtDBDAOSearchEdiMsgToEUROnlyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel Schedule에 대한 구주지역으로의 EDI 발송용 F/F 생성
	  * </pre>
	  */
	public VesselScheduleMgtDBDAOSearchEdiMsgToEUROnlyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mphn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_eml",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_info",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.integration").append("\n"); 
		query.append("FileName : VesselScheduleMgtDBDAOSearchEdiMsgToEUROnlyRSQL").append("\n"); 
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
		query.append("SELECT  MAX(DECODE(SEQ, 01, MSG_HDR)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 01, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 02, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 03, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 04, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 05, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 06, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 07, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 08, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 09, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 10, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 11, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 12, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 13, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 14, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 15, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 16, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 17, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 18, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 19, MSG_DTL)) ||" ).append("\n"); 
		query.append("        MAX(DECODE(SEQ, 20, MSG_DTL)) ||" ).append("\n"); 
		query.append("	    DECODE(@[usr_info], 'Y', 			/* 화면에서 check ='Y' 일 경우에만 사용자 정보를 보낸다 */" ).append("\n"); 
		query.append("        CHR(10)|| '{CONTACT_INFO'			||CHR(10)||" ).append("\n"); 
		query.append("        'CONTACT_USERID:'	|| @[usr_id]	||CHR(10)||" ).append("\n"); 
		query.append("        'CONTACT_PERSON:'	|| @[usr_nm]	||CHR(10)||" ).append("\n"); 
		query.append("        'CONTACT_TEL:'		|| @[mphn_no]	||CHR(10)|| " ).append("\n"); 
		query.append("        'CONTACT_FAX:'		|| @[fax_no]	||CHR(10)||" ).append("\n"); 
		query.append("        'CONTACT_EMAIL:'	|| @[usr_eml]	||CHR(10)||   " ).append("\n"); 
		query.append("        '}CONTACT_INFO')     AS MSG_ALL       " ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("	SELECT	ROW_NUMBER() OVER (ORDER BY CLPT_SEQ)   AS SEQ" ).append("\n"); 
		query.append("			,'BRAC:'		|| DECODE(T1.EDI_SND_KNT, 1, '9', '62')		||CHR(10)||" ).append("\n"); 
		query.append("			'VSL_CD:'		|| T1.VSL_CD					||CHR(10)||" ).append("\n"); 
		query.append("			'VSL_NM:'		|| T3.VSL_ENG_NM				||CHR(10)||" ).append("\n"); 
		query.append("			'VOY:'			|| T1.SKD_VOY_NO				||CHR(10)||" ).append("\n"); 
		query.append("			'DIR:'			|| T1.SKD_DIR_CD				||CHR(10)||" ).append("\n"); 
		query.append("			'CALLSIGN:'		|| T3.CALL_SGN_NO				||CHR(10)||" ).append("\n"); 
		query.append("			'LANE:'			|| T1.SLAN_CD					||CHR(10)||  " ).append("\n"); 
		query.append("			'LANE_NM:'		|| T4.VSL_SLAN_NM				||CHR(10)||" ).append("\n"); 
		query.append("			'TMNL_VSL_CD:'	|| T1.PLISM_VSL_CD				||CHR(10)||" ).append("\n"); 
		query.append("			'TMNL_VYG_NO:'	|| T1.PLISM_VOY_NO				||CHR(10)||" ).append("\n"); 
		query.append("			'O_MRN_NO:'	|| (	SELECT	MRN_NO || MRN_CHK_NO" ).append("\n"); 
		query.append("								FROM	BKG_CSTMS_KR_MF_REF_NO S" ).append("\n"); 
		query.append("								WHERE	S.VSL_CD		= T1.VSL_CD" ).append("\n"); 
		query.append("								AND		S.SKD_VOY_NO	= T1.SKD_VOY_NO" ).append("\n"); 
		query.append("								AND		S.SKD_DIR_CD	= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("								AND		S.PORT_CD		= @[vps_port_cd]" ).append("\n"); 
		query.append("								AND		S.IO_BND_CD		= 'O'" ).append("\n"); 
		query.append("							)	||CHR(10)||" ).append("\n"); 
		query.append("			'I_MRN_NO:'	|| (	SELECT	MRN_NO || MRN_CHK_NO" ).append("\n"); 
		query.append("								FROM	BKG_CSTMS_KR_MF_REF_NO S" ).append("\n"); 
		query.append("								WHERE	S.VSL_CD		= T1.VSL_CD" ).append("\n"); 
		query.append("								AND		S.SKD_VOY_NO	= T1.SKD_VOY_NO" ).append("\n"); 
		query.append("								AND		S.SKD_DIR_CD	= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("								AND		S.PORT_CD		= @[vps_port_cd]" ).append("\n"); 
		query.append("								AND		S.IO_BND_CD		= 'I'" ).append("\n"); 
		query.append("							)	||CHR(10)||" ).append("\n"); 
		query.append("			--::2014-02-04::append::--" ).append("\n"); 
		query.append("			'SSR_NO:'	|| (	SELECT   X.SVC_RQST_NO" ).append("\n"); 
		query.append("								FROM     BKG_CSTMS_ANR_VVD      X" ).append("\n"); 
		query.append("								WHERE    1 = 1" ).append("\n"); 
		query.append("								AND      X.VSL_CD               = @[vsl_cd]" ).append("\n"); 
		query.append("								AND      X.SKD_VOY_NO           = @[skd_voy_no]" ).append("\n"); 
		query.append("								AND      X.SKD_DIR_CD           = @[skd_dir_cd]" ).append("\n"); 
		query.append("							)	||CHR(10)||" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			'REMARK:'      || DECODE(T1.CLPT_SEQ, @[clpt_seq], REPLACE(REPLACE(NVL(T1.VPS_RMK, ' '), CHR(13)||CHR(10), ' '), CHR(9), ' '), NULL) AS MSG_HDR" ).append("\n"); 
		query.append("			,CHR(10) || '{PORT_INFO'                                                   	||CHR(10)||" ).append("\n"); 
		query.append("                		'PORT_IND:'    || DECODE(CLPT_SEQ, @[clpt_seq], '9', '153')		||CHR(10)||" ).append("\n"); 
		query.append("        				'LOC_CD:'      || VPS_PORT_CD									||CHR(10)||" ).append("\n"); 
		query.append("        				'LOC_DESC:'    || LOC_NM										||CHR(10)||" ).append("\n"); 
		query.append("        				'YARD_CD:'     || T1.YD_CD										||CHR(10)||" ).append("\n"); 
		query.append("        				'ETA:'         || TO_CHAR(VPS_ETA_DT, 'RRRRMMDDHH24MI')			||CHR(10)||" ).append("\n"); 
		query.append("        				'ETD:'         || TO_CHAR(VPS_ETD_DT, 'RRRRMMDDHH24MI')			||CHR(10)||" ).append("\n"); 
		query.append("        				'ETB:'         || TO_CHAR(VPS_ETB_DT, 'RRRRMMDDHH24MI')			||CHR(10)||" ).append("\n"); 
		query.append("        				'CCT:'         || TO_CHAR(VPS_ETB_DT - 0.416, 'RRRRMMDDHH24MI')	||CHR(10)||" ).append("\n"); 
		query.append("        				'FREE_TIME:'   || TO_CHAR(FT_DT,  'RRRRMMDD')					||CHR(10)||" ).append("\n"); 
		query.append("        				'}PORT_INFO'	AS MSG_DTL" ).append("\n"); 
		query.append("        		, T1.VSL_CD AS VSL_CD, T1.SKD_VOY_NO AS VOY_NO, T1.SKD_DIR_CD  AS DIR_CD		" ).append("\n"); 
		query.append("	FROM	VSK_VSL_PORT_SKD 	T1" ).append("\n"); 
		query.append("			, MDM_LOCATION 		T2" ).append("\n"); 
		query.append("			, MDM_VSL_CNTR 		T3" ).append("\n"); 
		query.append("			, MDM_VSL_SVC_LANE 	T4" ).append("\n"); 
		query.append("	WHERE	1   = 1" ).append("\n"); 
		query.append("	AND		T1.VPS_PORT_CD	= T2.LOC_CD" ).append("\n"); 
		query.append("	AND		T1.VSL_CD		= T3.VSL_CD" ).append("\n"); 
		query.append("	AND		T1.SLAN_CD		= T4.VSL_SLAN_CD" ).append("\n"); 
		query.append("	AND		T1.VSL_CD		= @[vsl_cd]" ).append("\n"); 
		query.append("	AND		T1.SKD_VOY_NO	= @[skd_voy_no]" ).append("\n"); 
		query.append("	AND		T1.SKD_DIR_CD	= @[skd_dir_cd]" ).append("\n"); 
		query.append("	AND		T1.CLPT_SEQ		>= @[clpt_seq]" ).append("\n"); 
		query.append("    AND     T4.VSL_TP_CD    = 'C' /*컨테이너선*/" ).append("\n"); 
		query.append("	AND		'S'				<> NVL(SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("GROUP BY VSL_CD, VOY_NO, DIR_CD" ).append("\n"); 

	}
}