/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOMakeFlatFileMasterInfoRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son Yun Seuk
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOMakeFlatFileMasterInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * MakeFlatFileMasterInfo
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOMakeFlatFileMasterInfoRSQL(){
		setQuery();

		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msn_nbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_loc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("un_pod_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("resnd_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_nbr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ob_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_flag",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("kt_pa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_sign",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("un_pol_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_scac",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_customs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("im_customs",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bay_vsl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT '$$$MSGSTART:'||" ).append("\n");
		query.append("DECODE(@[resnd_chk],'P',RPAD('HJSPORT1',20), RPAD('SSHJSC0002', 20))|| /* Sender ID */" ).append("\n");
		query.append("DECODE(@[resnd_chk],'P',DECODE(@[kt_pa],20,RPAD('KMPAE010',20),30,RPAD('KMPAE030',20),622,RPAD('KMPAE050',20),31,RPAD('KMPAE030',20)),RPAD('MADECLINTS',20))|| /*ReceiverID*/" ).append("\n");
		query.append("RPAD('CUSREP',10)||CHR(10)|| /* Message Type */" ).append("\n");
		query.append("'{MASTER:'||DECODE(@[mrn_type],'I','5AV','5AT')||CHR(10)||	/* 전자문서코드 */" ).append("\n");
		query.append("'PLI:' ||@[im_customs] ||CHR(10)||	/* 신고세관 */" ).append("\n");
		query.append("'RPLI:' ||@[loc_customs] ||CHR(10)|| /* 신고세관과 */" ).append("\n");
		query.append("'VSLCOUNTRY:' ||@[vsl_flag] ||CHR(10)|| /*	Vessel Flag */" ).append("\n");
		query.append("'VSLFULLNAME:' ||FC2S(SUBSTR(@[bay_vsl_nm],1,30),'S')||CHR(10)||	/* VSL Name */" ).append("\n");
		query.append("'CALLSIGN:' ||@[call_sign] ||CHR(10)|| /* CALL SIGN */" ).append("\n");
		query.append("'NEWMOD:' ||'9' ||CHR(10)|| /* 기능코드 */" ).append("\n");
		query.append("'MRNNBR:' ||@[mrn_nbr] ||CHR(10)||	/* MRN_NBR */" ).append("\n");
		query.append("'VSLCODE:' ||SUBSTR(@[vsl_cd], 1, 4) ||CHR(10)|| /* VSL_CODE */" ).append("\n");
		query.append("'VSLVOY:' ||SUBSTR(@[vsl_cd], 5, 4) ||CHR(10)|| /*	VOY_NO */" ).append("\n");
		query.append("'VSLDIR:' ||SUBSTR(@[vsl_cd], 9, 1) ||CHR(10)|| /*	Direction Code */" ).append("\n");
		query.append("'SENDDATE:' ||TO_CHAR(SYSDATE,'YYYYMMDD') ||CHR(10)|| /* Sending Date */" ).append("\n");
		query.append("'SENDTIME:' ||TO_CHAR(SYSDATE,'HH24MI') ||CHR(10)|| /* sending Time */" ).append("\n");
		query.append("'PARTY:' ||@[vndr_scac] ||CHR(10)|| /* SCAC */" ).append("\n");
		query.append("'POL:' ||DECODE(@[mrn_type],'O',NVL(DECODE(@[un_pol_loc],'KRICH','KRINC','KRPYT','KRPTK',@[un_pol_loc]),@[pol_loc]),NULL) ||CHR(10)|| /*	Port Of Loading	*/" ).append("\n");
		query.append("'POD:' ||DECODE(@[mrn_type],'I',NVL(DECODE(@[un_pod_loc],'KRICH','KRINC','KRPYT','KRPTK',@[un_pod_loc]),@[pod_loc]),NULL) ||CHR(10)|| /*	Port Of Disch	*/" ).append("\n");
		query.append("'ETA:' ||TO_CHAR(@[eta_dt], 'YYYYMMDD') ||CHR(10)|| /* ETA Date */" ).append("\n");
		query.append("'ETD:' ||TO_CHAR(@[etd_dt], 'YYYYMMDD') ||CHR(10)|| /* ETD Date */" ).append("\n");
		query.append("'MBT:' ||KV.MST_BL_KNT ||CHR(10)|| /* Master BL CNT */" ).append("\n");
		query.append("'CBT:' ||KV.CNSL_BL_KNT ||CHR(10)|| /* Console BL CNT */" ).append("\n");
		query.append("'TWGT:' ||KV.TTL_WGT ||CHR(10)||	/* Total Weight */" ).append("\n");
		query.append("'TMEA:' ||KV.TTL_MEAS_QTY ||CHR(10)|| /* Total Measure */" ).append("\n");
		query.append("'TPKG:' ||KV.TTL_PCK_QTY ||CHR(10)|| /* Total Pakage */" ).append("\n");
		query.append("'FCT:' ||KV.TTL_FULL_KNT ||CHR(10)|| /* Full CNTR CNT */" ).append("\n");
		query.append("'ECT:' ||KV.TTL_MTY_KNT ||CHR(10)|| /* Empty CNTR CNT */" ).append("\n");
		query.append("'JOINT:' ||@[msn_nbr] ||CHR(10)|| /* 공동배선사수 */" ).append("\n");
		query.append("'AGENCY:' ||'HANJIN SHIPPING CO. LTD' ||CHR(10)|| /* 선박대리점명 */" ).append("\n");
		query.append("'INPORT_YYYY:' ||TO_CHAR(TO_DATE(@[eta_dt], 'YYYYMMDD'),'yyyy') ||CHR(10)||	/* 입항년도 : ETA 이용 */" ).append("\n");
		query.append("'INPORT_CNT:' ||TO_CHAR(NVL(KV.CALL_KNT,0),'FM000') ||CHR(10)|| /* 입항횟수 */" ).append("\n");
		query.append("'PORT_AUTH:' ||DECODE(DECODE(@[ob_type],'N',@[pod_loc],@[pol_loc]),'KRPUS','020','KRINC','030','KRPYT','031','622') ||CHR(10)|| /* 항만청코드 */" ).append("\n");
		query.append("'VSLCOM_CODE:' ||DECODE(SUBSTR(@[svr_id],1,1),'D','KM-C-8444',DECODE(DECODE(@[ob_type],'N',@[pod_loc],@[pol_loc]),'KRPUS','BS-Z-8828','KM-S-8828')) ||CHR(10)|| /* 해수부 선사코드 */" ).append("\n");
		query.append("'}MASTER'||CHR(10) FLAT_DATA" ).append("\n");
		query.append("FROM BKG_CSTMS_KR_VVD_SMRY KV" ).append("\n");
		query.append("WHERE KV.VSL_CD = SUBSTR(@[vsl_cd],1,4)" ).append("\n");
		query.append("AND KV.SKD_VOY_NO = SUBSTR(@[vsl_cd],5,4)" ).append("\n");
		query.append("AND KV.SKD_DIR_CD = SUBSTR(@[vsl_cd],9,1)" ).append("\n");
		query.append("AND KV.MRN_NO =	SUBSTR(@[mrn_nbr], 1, 10)" ).append("\n");
		query.append("AND KV.MRN_CHK_NO = SUBSTR(@[mrn_nbr], 11, 1)" ).append("\n");
		query.append("AND KV.VVD_SEQ = @[kv_seq]" ).append("\n");
		query.append("AND ((@[ob_type] IN ('A','B','C','D') AND KV.OB_DECL_TP_CD IN ('A','B','C','D')) OR (@[ob_type] = 'N' AND KV.OB_DECL_TP_CD = @[ob_type]))" ).append("\n");

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n");
		query.append("FileName : KorCustomsTransmissionDBDAOMakeFlatFileMasterInfoRSQL").append("\n");
		query.append("*/").append("\n");
	}
}