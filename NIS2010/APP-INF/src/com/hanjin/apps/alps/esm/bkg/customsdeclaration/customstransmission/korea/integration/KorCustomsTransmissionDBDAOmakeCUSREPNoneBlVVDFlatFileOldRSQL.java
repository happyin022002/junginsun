/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeCUSREPNoneBlVVDFlatFileOldRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOmakeCUSREPNoneBlVVDFlatFileOldRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CUSREP Flat File을 만든다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeCUSREPNoneBlVVDFlatFileOldRSQL(){
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
		params.put("un_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_call_sgn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("un_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_knt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("locl_cstms_prt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOmakeCUSREPNoneBlVVDFlatFileOldRSQL").append("\n"); 
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
		query.append("  DECODE(@[io_bnd_cd],'I','5IA','5CC')||'~'|| -- /* 전자문서코드 */" ).append("\n"); 
		query.append("        @[locl_cstms_cd]   ||'~'|| 			  -- /* 신고세관   */" ).append("\n"); 
		query.append("        @[locl_cstms_prt_cd]  ||'~'||         -- /*신고세관과  */" ).append("\n"); 
		query.append("		@[vsl_cnt_cd]    ||'~'|| 			  --/* Vessel Flag  */" ).append("\n"); 
		query.append("  BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[vsl_nm],1,17),'Y') ||'~'|| --/* VSL Name  */" ).append("\n"); 
		query.append("  @[vsl_call_sgn_cd]  ||'~'|| --/* CALL SIGN  */" ).append("\n"); 
		query.append("  '9'      ||'~'|| --/* 기능코드  */              " ).append("\n"); 
		query.append("  @[mrn_no]     ||'~'|| --/* MRN_NBR   */" ).append("\n"); 
		query.append("  SUBSTR(@[vvd], 1, 4)  ||'~'|| --/* VSL_CODE  */" ).append("\n"); 
		query.append("  SUBSTR(@[vvd], 5, 4)  ||'~'|| --/* VOY_NO   */" ).append("\n"); 
		query.append("  SUBSTR(@[vvd], 9, 1)  ||'~'|| --/* Direction Code */" ).append("\n"); 
		query.append("  TO_CHAR(SYSDATE,'yymmdd') ||'~'|| --/* Sending Date */" ).append("\n"); 
		query.append("  TO_CHAR(SYSDATE,'hh24mi') ||'~'|| --/* sending Time */" ).append("\n"); 
		query.append("  'SMLM'     ||'~'|| --/* SCAC   */" ).append("\n"); 
		query.append("  DECODE(@[io_bnd_cd],'O',NVL(DECODE(@[un_pol_cd],'KRICH','KRINC','KRPYT','KRPTK',@[un_pol_cd]),@[pol_cd]),NULL) ||'~'|| --/* Port Of Loading */" ).append("\n"); 
		query.append("  DECODE(@[io_bnd_cd],'I',NVL(DECODE(@[un_pod_cd],'KRICH','KRINC','KRPYT','KRPTK',@[un_pod_cd]),@[pod_cd]),NULL) ||'~'|| --/* Port Of Disch */" ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(@[eta_dt], 'YYYY-MM-DD'),'yymmdd')	||'~'||	/*	ETA Date		*/" ).append("\n"); 
		query.append("  TO_CHAR(TO_DATE(@[etd_dt], 'YYYY-MM-DD HH24MI'),'YYYYMMDDHH24MI') ||'~'|| --/* ETD Date  */" ).append("\n"); 
		query.append("  0     ||'~'|| --/* Master BL CNT:KV.MST_BL_KNT */" ).append("\n"); 
		query.append("  0   ||'~'|| --/* Console BL CNT:KV.CNSL_BL_KNT */" ).append("\n"); 
		query.append("  0          ||'~'|| --/* Total Weight:KV.TTL_WGT */" ).append("\n"); 
		query.append("  0   ||'~'|| --/* Total Measure:KV.TTL_MEAS_QTY */" ).append("\n"); 
		query.append("  0   ||'~'|| --/* Total Pakage:KV.TTL_PCK_QTY */" ).append("\n"); 
		query.append("  0   ||'~'|| --/* Full CNTR CNT:KV.TTL_FULL_KNT */ㄸ" ).append("\n"); 
		query.append("  0   ||'~'|| --/* Empty CNTR CNT: */  " ).append("\n"); 
		query.append("        NULL    ||'~'|| --/* 공동배선사수 */" ).append("\n"); 
		query.append("  'SM LINE CORPORATION' ||'~'|| --/* 선박대리점명 */" ).append("\n"); 
		query.append("        TO_CHAR(TO_DATE(@[eta_dt], 'YYYY-MM-DD'),'yyyy') ||'~'|| --/* 입항년도 : ETA 이용 */" ).append("\n"); 
		query.append("	    TO_CHAR(NVL(@[call_knt],0),'FM000') ||'~'|| --/* 입항횟수 */" ).append("\n"); 
		query.append("        DECODE(DECODE(@[io_bnd_cd],'I',@[pod_cd],@[pol_cd]),'KRPUS','020','KRINC','030','KRPTK','031','KRUSN','820','KRGIN','050','622') ||'~'|| --/* 항만청코드 */" ).append("\n"); 
		query.append("  DECODE(DECODE(@[io_bnd_cd],'I',@[pod_cd],@[pol_cd])" ).append("\n"); 
		query.append("                            , 'KRPUS', 'OS-L-2001'" ).append("\n"); 
		query.append("                            , 'KRKAN', 'OS-L-2001'" ).append("\n"); 
		query.append("                            , 'KRINC', 'OS-L-2001'" ).append("\n"); 
		query.append("                            , 'KRUSN', 'OS-L-2001'" ).append("\n"); 
		query.append("                            , 'KRPTK', 'OS-L-2001'" ).append("\n"); 
		query.append("							, 'KRGIN', 'OS-L-2001'" ).append("\n"); 
		query.append("             ,' ') FLATFILE_DATA --/* 해수부 선사코드 */ " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}