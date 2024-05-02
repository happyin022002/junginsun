/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeKRTransCancellFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier :
*@LastVersion : 1.0
* 2011.11.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeKRTransCancellFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * Korea Trans Cancellation Flat File을 만든다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeKRTransCancellFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_cstms_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("etd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_cxl_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_cxl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_cxl_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnsl_bl_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("smp_bl_knt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeKRTransCancellFlatFileRSQL").append("\n");
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
		query.append("SELECT" ).append("\n");
		query.append("		@[trsm_cxl_tp_cd]||'~'||	/*	신청타입	*/" ).append("\n");
		query.append("		@[locl_cstms_cd] || TO_CHAR(SYSDATE,'YY')||" ).append("\n");
		query.append("		    (SELECT LPAD(MAX(MF_SND_SEQ),4,'0') " ).append("\n");
		query.append("			 FROM BKG_CSTMS_KR_SND_LOG" ).append("\n");
		query.append("			 WHERE MSG_LOG_TP_ID = '5VD'" ).append("\n");
		query.append("			   AND SND_DT = TO_DATE(@[snd_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n");
		query.append("			   AND OFC_CD = DECODE(@[io_bnd_cd],'I',@[pod_cd],@[pol_cd])" ).append("\n");
		query.append("			   AND FLT_FILE_REF_NO = '*') ||'~'||	/*	제출번호	*/" ).append("\n");
		query.append("		@[vvd]			 ||'~'||	/*	VVD	*/" ).append("\n");
		query.append("		@[vsl_nm]	 	 ||'~'||	/*	Vessel Name	*/" ).append("\n");
		query.append("		DECODE(@[io_bnd_cd],'I',@[pod_cd],@[pol_cd]) ||'~'||	/*	LOC	*/" ).append("\n");
		query.append("		TO_CHAR(SYSDATE,'YYYYMMDD')	 ||'~'||	/*	APP_DTM	*/" ).append("\n");
		query.append("		DECODE(@[io_bnd_cd],'I',TO_CHAR(TO_DATE(@[eta_dt],'YYYY-MM-DD HH24MI'),'YYYYMMDDHH24MI'),TO_CHAR(TO_DATE(@[etd_dt],'YYYY-MM-DD HH24MI'),'YYYYMMDDHH24MI')) ||'~'||	/*	DTM	*/" ).append("\n");
		query.append("		@[trsm_cxl_rsn_cd]||'~'||	/*	WITHDRAW_TYPE	*/" ).append("\n");
		query.append("		@[trsm_cxl_desc] ||'~'||	/*	WITHDRAW_REASON	*/" ).append("\n");
		query.append("		@[mrn_no]	 	 ||'~'||	/*	MRN_NO	*/" ).append("\n");
		query.append("		@[smp_bl_knt]	 ||'~'||	/*	Simple Master B/L	*/" ).append("\n");
		query.append("		@[cnsl_bl_knt]	 ||'~'||	/*	Consol Master B/L	*/" ).append("\n");
		query.append("		@[hbl_knt]		 ||'~'||	/*	House B/L	*/" ).append("\n");
		query.append("		(SELECT VNDR_LOCL_LANG_NM ||'~'||	/*	신청인 상호	*/" ).append("\n");
		query.append("				CEO_NM			  ||'~'||	/*	대표자명	*/" ).append("\n");
		query.append("				COM_ConstantMgr_PKG.COM_getScacCode_FNC()			  ||'~'||	/*	신고인 세관 등록번호	*/" ).append("\n");
		query.append("				(SELECT XTN_PHN_NO " ).append("\n");
		query.append("				 FROM COM_USER" ).append("\n");
		query.append("			     WHERE USR_ID = @[user_id] AND USE_FLG = 'Y') ||'~'||	/*	전화번호	*/" ).append("\n");
		query.append("				SUBSTR(LOCL_LANG_ADDR,1,35)   ||'~'||	/*	주소1	*/ " ).append("\n");
		query.append("				SUBSTR(LOCL_LANG_ADDR,36,70)  ||'~'||	/*	주소2	*/" ).append("\n");
		query.append("				SUBSTR(LOCL_LANG_ADDR,71,100) ||'~'		/*	주소3	*/" ).append("\n");
		query.append("		 FROM MDM_VENDOR" ).append("\n");
		query.append("		 WHERE VNDR_SEQ = 185647" ).append("\n");
		query.append("		   AND VNDR_CNT_CD = 'KR')" ).append("\n");
		query.append("FROM	DUAL" ).append("\n");

	}
}