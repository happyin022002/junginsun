/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOmakeMACAMDFlatFileRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.04
*@LastModifier :
*@LastVersion : 1.0
* 2012.12.04
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

public class KorCustomsTransmissionDBDAOmakeMACAMDFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MACAMD Flatfile을 만든다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOmakeMACAMDFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bd_area_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dchg_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_tml_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_pck_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("un_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_pa",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ttl_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_year",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOmakeMACAMDFlatFileRSQL").append("\n");
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
		query.append("SELECT	MAX(" ).append("\n");
		query.append("DECODE(@[io_bnd_cd],'O','6SJ','6SK')	||'~'||		/*	Message Code		*/" ).append("\n");
		query.append("TO_CHAR(@[kt_pa],'FM000') || @[call_year]	|| TO_CHAR(@[call_knt],'FM000') || SUBSTR(@[vsl_call_sgn_cd],1,9)	||'~'||     /*	- Call Sign			*/" ).append("\n");
		query.append("TO_CHAR(SYSDATE,'YYYYMMDDHH24MI')		||'~'||     /*	전송 Date & Time	*/" ).append("\n");
		query.append("TO_CHAR(@[kt_pa],'FM000')               ||'~'||     /*	청 코드	            */" ).append("\n");
		query.append("@[mrn_no]								||'~'||     /*	Manifest Reference#	*/" ).append("\n");
		query.append("COM_ConstantMgr_PKG.COM_getScacCode_FNC()                           		||'~'||		/*	SCAC				*/" ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(@[io_bnd_cd],'I',@[pod_cd],@[pol_cd])" ).append("\n");
		query.append(", 'KRPUS', 'BS-Z-8828'" ).append("\n");
		query.append(", 'KRKAN', 'KM-S-8828'" ).append("\n");
		query.append(", 'KRINC', 'KM-S-8828'" ).append("\n");
		query.append(", 'KRUSN', 'BS-G-0010'" ).append("\n");
		query.append(", 'KRPTK', 'KM-S-8828'" ).append("\n");
		query.append(", 'KRGIN', 'KM-S-8828'" ).append("\n");
		query.append(",' ') ||'~'|| /*  선사/대리점 코드    */" ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("@[vvd]									||'~'||     /*	VVD					*/" ).append("\n");
		query.append("SUBSTR(@[vsl_call_sgn_cd],1,9)			||'~'||     /*	Call Sign			*/" ).append("\n");
		query.append("BKG_SPCLCHAR_CONV_FNC(SUBSTR(@[vsl_nm],1,17),'Y')	 ||'~'||		/*	Vessel Name			*/" ).append("\n");
		query.append("@[vsl_cnt_cd]							||'~'||     /*  Vessel Flag			*/" ).append("\n");
		query.append("@[call_year]							||'~'||     /*	입항 년도			*/" ).append("\n");
		query.append("TO_CHAR(@[call_knt],'FM000')            ||'~'||     /*	입항 회수			*/" ).append("\n");
		query.append("@[bl_no]								||'~'||		/*	B/L No				*/" ).append("\n");
		query.append("''										||'~'||		/*	M-B/L Sequence No.	*/" ).append("\n");
		query.append("'A'                   					||'~'||     /*  Correction Code     *//* 일괄삭제,정정은 운항정보정정..'A' */" ).append("\n");
		query.append("''										||'~'||		/*	B/L Type			*/" ).append("\n");
		query.append("''										||'~'||		/*	Trans. Indicator	*/" ).append("\n");
		query.append("@[dchg_mzd_cd]                   		||'~'||     /*	하역방법,2-기계하역	*/" ).append("\n");
		query.append("@[un_pol_cd]							||'~'||     /*	Booking POL			*/" ).append("\n");
		query.append("@[un_pod_cd]							||'~'||     /*	Booking POD			*/" ).append("\n");
		query.append("@[io_tml_loc_cd]                        ||'~'||     /*	반출입 부두 코드	*/" ).append("\n");
		query.append("@[bd_area_cd]							||'~'||		/*	장치장코드			*/" ).append("\n");
		query.append("@[ttl_pck_ut_cd]						||'~'||		/*	Package Code		*/" ).append("\n");
		query.append("''										||'~'||		/*	품목 코드, HS Code	*/" ).append("\n");
		query.append("''										||'~'||		/*	Cargo Description1	*/" ).append("\n");
		query.append("''										||'~'||		/*	Cargo Description2	*/" ).append("\n");
		query.append("''										||'~'||     /*	IMO Class 1			*/" ).append("\n");
		query.append("''										||'~'||     /*	IMO Class 2			*/" ).append("\n");
		query.append("''										||'~'||     /*	IMO Class 3			*/" ).append("\n");
		query.append("TRIM(TO_CHAR(REPLACE(@[ttl_wgt],',',''),'999999999999999.99'))||'~'||		/*	Weight				*/" ).append("\n");
		query.append("@[ttl_meas_ut_cd]						||'~'||     /*	용적톤 단위			*/" ).append("\n");
		query.append("@[ttl_meas_qty]							||'~'||		/*	Measure				*/" ).append("\n");
		query.append("''								    	||'~'||		/*	Shipper Name1		*/" ).append("\n");
		query.append("''									  	||'~'||		/*	Shipper Addr 1		*/" ).append("\n");
		query.append("''									 	||'~'||		/*	Shipper Addr 2		*/" ).append("\n");
		query.append("''									 	||'~'||		/*	Shipper Addr 3		*/" ).append("\n");
		query.append("''								    	||'~'||		/*	CNEE Name 1			*/" ).append("\n");
		query.append("''									 	||'~'||		/*	CNEE Addr 1			*/" ).append("\n");
		query.append("''										||'~'||		/*	CNEE Addr 2			*/" ).append("\n");
		query.append("''										||'~'||		/*	CNEE Addr 3			*/" ).append("\n");
		query.append("''										||'~'||		/*	NTFY Name 1			*/" ).append("\n");
		query.append("''									 	||'~'||		/*	NTFY Addr1			*/" ).append("\n");
		query.append("''										||'~'||		/*	NTFY Addr2			*/" ).append("\n");
		query.append("''										||'~'||		/*	NTFY Addr3			*/" ).append("\n");
		query.append("" ).append("\n");
		query.append("(" ).append("\n");
		query.append("SELECT SUBSTR(ATTR_CTNT2,1,2)||'-'||SUBSTR(ATTR_CTNT2,3,1)||'-'||SUBSTR(ATTR_CTNT2,4,4) AS DSCH_COM" ).append("\n");
		query.append("FROM BKG_HRD_CDG_CTNT" ).append("\n");
		query.append("WHERE    HRD_CDG_ID = 'KR_WHF_VSL_INFO'" ).append("\n");
		query.append("AND  ATTR_CTNT1 = DECODE(@[io_bnd_cd],'I',@[pod_cd],@[pol_cd])" ).append("\n");
		query.append(") ||'~'|| /*  하역회사 부호,(주)한진 */" ).append("\n");
		query.append("''										     			/*	사업자 등록 번호	*/" ).append("\n");
		query.append(")||'~' FLATFILE_DATA" ).append("\n");
		query.append("FROM	DUAL" ).append("\n");

	}
}