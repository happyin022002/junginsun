/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : Kor24CustomsTransmissionDBDAOmakeCUSREPFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.02
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.02 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Kor24CustomsTransmissionDBDAOmakeCUSREPFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CUSREP Flat File을 만든다.
	  * </pre>
	  */
	public Kor24CustomsTransmissionDBDAOmakeCUSREPFlatFileRSQL(){
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
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("msn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea24.integration").append("\n"); 
		query.append("FileName : Kor24CustomsTransmissionDBDAOmakeCUSREPFlatFileRSQL").append("\n"); 
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
		query.append("		DECODE(@[io_bnd_cd],'I','5AV','5AT')||'~'||	/*	전자문서코드	*/" ).append("\n"); 
		query.append("		@[locl_cstms_cd]			||'~'||	/*	신고세관		*/" ).append("\n"); 
		query.append("		@[locl_cstms_prt_cd]		||'~'||	/*	신고세관과		*/" ).append("\n"); 
		query.append("		@[vsl_cnt_cd]				||'~'||	/*	Vessel Flag		*/" ).append("\n"); 
		query.append("        BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[vsl_nm],1,30),'Y')	||'~'||	/*	VSL Name		*/" ).append("\n"); 
		query.append("		@[vsl_call_sgn_cd]		||'~'||	/*	CALL SIGN		*/" ).append("\n"); 
		query.append("		'9'						||'~'||	/*	기능코드		*/" ).append("\n"); 
		query.append("		@[mrn_no]					||'~'||	/*	MRN_NBR			*/" ).append("\n"); 
		query.append("		SUBSTR(@[vvd], 1, 4)		||'~'||	/*	VSL_CODE		*/" ).append("\n"); 
		query.append("		SUBSTR(@[vvd], 5, 4)		||'~'||	/*	VOY_NO			*/" ).append("\n"); 
		query.append("		SUBSTR(@[vvd], 9, 1)		||'~'||	/*	Direction Code	*/" ).append("\n"); 
		query.append("		TO_CHAR(SYSDATE,'yymmdd') ||'~'||	/*	Sending Date	*/" ).append("\n"); 
		query.append("		TO_CHAR(SYSDATE,'hh24mi') ||'~'||	/*	sending Time	*/" ).append("\n"); 
		query.append("		'SMLM'					||'~'||	/*	SCAC			*/" ).append("\n"); 
		query.append("		DECODE(@[io_bnd_cd],'O',NVL(DECODE(@[un_pol_cd],'KRICH','KRINC','KRPYT','KRPTK',@[un_pol_cd]),@[pol_cd]),NULL) ||'~'||	/*	Port Of Loading	*/" ).append("\n"); 
		query.append("		DECODE(@[io_bnd_cd],'I',NVL(DECODE(@[un_pod_cd],'KRICH','KRINC','KRPYT','KRPTK',@[un_pod_cd]),@[pod_cd]),NULL) ||'~'||	/*	Port Of Disch	*/" ).append("\n"); 
		query.append("		TO_CHAR(TO_DATE(@[eta_dt], 'YYYY-MM-DD'),'yymmdd')	||'~'||	/*	ETA Date		*/" ).append("\n"); 
		query.append("#if( ${pol_cd} != '')" ).append("\n"); 
		query.append("		TO_CHAR(TO_DATE(@[etd_dt], 'YYYY-MM-DD HH24MI'),'YYYYMMDDHH24MI')	||'~'||	/*	ETD Date		*/" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        TO_CHAR(TO_DATE(@[etd_dt], 'YYYY-MM-DD HH24MI'),'yymmdd')	||'~'||	/*	ETD Date		*/" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		KV.MST_BL_KNT				||'~'||	/*	Master BL CNT	*/" ).append("\n"); 
		query.append("		KV.CNSL_BL_KNT			||'~'||	/*	Console BL CNT	*/" ).append("\n"); 
		query.append("		TRIM(TO_CHAR(KV.TTL_WGT,'999999999999999.99'))||'~'||	/*	Total Weight	*/" ).append("\n"); 
		query.append("		KV.TTL_MEAS_QTY			||'~'||	/*	Total Measure	*/" ).append("\n"); 
		query.append("		KV.TTL_PCK_QTY			||'~'||	/*	Total Pakage	*/" ).append("\n"); 
		query.append("		KV.TTL_FULL_KNT			||'~'||	/*	Full CNTR CNT	*/" ).append("\n"); 
		query.append("		KV.TTL_MTY_KNT			||'~'||	/*	Empty CNTR CNT	*/" ).append("\n"); 
		query.append("		@[msn_no]					||'~'||	/*	공동배선사수	*/" ).append("\n"); 
		query.append("		'SM LINE CORPORATION' ||'~'||	/*	선박대리점명	*/" ).append("\n"); 
		query.append("        TO_CHAR(TO_DATE(@[eta_dt], 'YYYY-MM-DD'),'yyyy') ||'~'||	/* 입항년도 : ETA 이용 */" ).append("\n"); 
		query.append("        TO_CHAR(NVL(KV.CALL_KNT,0),'FM000') ||'~'|| /* 입항횟수 */" ).append("\n"); 
		query.append("        DECODE(DECODE(@[io_bnd_cd],'I',@[pod_cd],@[pol_cd]),'KRPUS','020','KRINC','030','KRPTK','031','KRUSN','820','KRGIN','050','622') ||'~'|| /* 항만청코드 */" ).append("\n"); 
		query.append("		DECODE(DECODE(@[io_bnd_cd],'I',@[pod_cd],@[pol_cd])" ).append("\n"); 
		query.append("                   									, 'KRPUS', 'OS-L-2001'" ).append("\n"); 
		query.append("                   									, 'KRKAN', 'OS-L-2001'" ).append("\n"); 
		query.append("                   									, 'KRINC', 'OS-L-2001'" ).append("\n"); 
		query.append("                   									, 'KRUSN', 'OS-L-2001'" ).append("\n"); 
		query.append("                   									, 'KRPTK', 'OS-L-2001'" ).append("\n"); 
		query.append("													, 'KRGIN', 'OS-L-2001'" ).append("\n"); 
		query.append("													,' ') /* 해수부 선사코드 */ FLATFILE_DATA" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_ADV_KR_VVD_SMRY KV" ).append("\n"); 
		query.append("WHERE	KV.VSL_CD			=	SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND		KV.SKD_VOY_NO	    =	SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND		KV.SKD_DIR_CD		=	SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND		KV.MRN_NO			=	SUBSTR(@[mrn_no], 1, 10)" ).append("\n"); 
		query.append("AND		KV.MRN_CHK_NO		=	SUBSTR(@[mrn_no], 11, 1)" ).append("\n"); 
		query.append("AND		KV.VVD_SEQ			=	@[vvd_seq]" ).append("\n"); 
		query.append("AND     ((@[in_type] IN ('A','B','C','D','M') AND KV.OB_DECL_TP_CD IN ('A','B','C','D','M')) OR (@[in_type] = 'N' AND KV.OB_DECL_TP_CD = @[in_type]))" ).append("\n"); 

	}
}