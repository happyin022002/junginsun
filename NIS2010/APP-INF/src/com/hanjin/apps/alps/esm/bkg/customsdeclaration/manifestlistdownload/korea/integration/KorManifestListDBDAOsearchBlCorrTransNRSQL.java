/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOsearchBlCorrTransNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchBlCorrTransNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 세관전송되지 않은 B/L정보 및 Correction정보를 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchBlCorrTransNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("trans_chk",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("biz_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("submit_chk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchBlCorrTransNRSQL").append("\n"); 
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
		query.append("SELECT KT.CSTMS_BL_NO BL_NO" ).append("\n"); 
		query.append("     , KT.BL_NO ORG_BL_NO" ).append("\n"); 
		query.append("     , KT.CSTMS_DECL_TP_CD CSTMS_DECL_TP_CD" ).append("\n"); 
		query.append("     , KT.TRNS_SEQ TRNS_SEQ" ).append("\n"); 
		query.append("     , NVL(DECODE(KC.KR_CSTMS_CORR_ID,'A','01','B','02','D','03','F','04',KC.KR_CSTMS_CORR_ID), DECODE(KT.KR_BL_AMDT_STS_CD, 'I', '03', 'X', '04', 'V', '02', 'U', '02', KT.KR_BL_AMDT_STS_CD)) KR_CSTMS_CORR_ID" ).append("\n"); 
		query.append("     , DECODE(@[submit_chk],'Y',KC.CORR_RSN,' ') CORR_RSN" ).append("\n"); 
		query.append("     , KT.BKG_NO BKG_NO" ).append("\n"); 
		query.append("     , @[vvd] VVD" ).append("\n"); 
		query.append("     , DECODE(KT.BKG_CGO_TP_CD,'P','E',KT.KR_CSTMS_BL_TP_CD) KR_CSTMS_BL_TP_CD" ).append("\n"); 
		query.append("     , DECODE(KT.KR_CSTMS_BL_TP_CD,'C',NVL(KT.CSTMS_FWRD_ID,' '),'') CSTMS_FWRD_ID" ).append("\n"); 
		query.append("     , KT.POR_CD POR_CD" ).append("\n"); 
		query.append("     , KT.POL_CD POL_CD" ).append("\n"); 
		query.append("     , KT.POD_CD POD_CD" ).append("\n"); 
		query.append("     , KT.DEL_CD DEL_CD" ).append("\n"); 
		query.append("     , KT.PCK_QTY PCK_QTY" ).append("\n"); 
		query.append("     , DECODE(KT.BKG_CGO_TP_CD,'P','CN',KT.PCK_TP_CD) PCK_TP_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(KT.WGT_UT_CD,'   '),'LBS',ROUND(NVL(KT.CNTR_TTL_WGT,0)*0.4536,3),NVL(KT.CNTR_TTL_WGT,0)) CNTR_TTL_WGT" ).append("\n"); 
		query.append("     , DECODE(NVL(KT.WGT_UT_CD,'   '),'LBS','KGS',NVL(KT.WGT_UT_CD,'   ')) WGT_UT_CD" ).append("\n"); 
		query.append("     , DECODE(NVL(KT.BL_MEAS_UT_CD,'   '),'CBF',ROUND(NVL(KT.MEAS_QTY,0)*0.0283,3),NVL(KT.MEAS_QTY,0)) MEAS_QTY" ).append("\n"); 
		query.append("     , DECODE(NVL(KT.BL_MEAS_UT_CD,'   '),'CBF','CBM',NVL(KT.BL_MEAS_UT_CD,'   ')) MEAS_UT_CD" ).append("\n"); 
		query.append("     , KT.BD_AREA_CD BD_AREA_CD" ).append("\n"); 
		query.append("     , KT.CSTMS_CRR_IN_LOC_WH_CD" ).append("\n"); 
		query.append("     , KT.MST_BL_SEQ_NO MSN_NO" ).append("\n"); 
		query.append("     , KT.IMDG_CLSS_CD IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , KT.N2ND_IMDG_CLSS_CD N2ND_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , KT.N3RD_IMDG_CLSS_CD N3RD_IMDG_CLSS_CD" ).append("\n"); 
		query.append("     , KT.KR_CSTMS_WH_TP_CD KR_CSTMS_WH_TP_CD" ).append("\n"); 
		query.append("     , REPLACE(KT.KR_WH_CD,CHR(9),' ') KR_WH_CD" ).append("\n"); 
		query.append("     , DECODE(KT.BKG_CGO_TP_CD,'P','EMPTY',REPLACE(KT.CGO_DESC1,CHR(9),' ')) CGO_DESC1" ).append("\n"); 
		query.append("     , REPLACE(KT.CGO_DESC2,CHR(9),' ') CGO_DESC2" ).append("\n"); 
		query.append("     , KT.FRT_FWRD_CD FRT_FWRD_CD" ).append("\n"); 
		query.append("     , DECODE(KT.MF_SND_DT, NULL, 'N', 'Y') MF_SND_DT" ).append("\n"); 
		query.append("     , KT.BKG_CGO_TP_CD BKG_CGO_TP_CD" ).append("\n"); 
		query.append("     , KT.KR_CSTMS_BND_CD KR_CSTMS_BND_CD" ).append("\n"); 
		query.append("     , KT.TS_POL_CD TS_POL_CD" ).append("\n"); 
		query.append("     , KT.TS_POD_CD TS_POD_CD" ).append("\n"); 
		query.append("     , KC.SMT_AMD_NO SMT_AMD_NO" ).append("\n"); 
		query.append("     , @[io_bnd_cd] IO_BND_CD" ).append("\n"); 
		query.append("     , @[trans_chk] TRANS_CHK" ).append("\n"); 
		query.append("     , DECODE(TO_NUMBER(NVL(KT.CSTMS_OFC_CTY_CD,'0')),0,DECODE(@[cstms_decl_tp_cd],'I',DECODE(KT.TS_POD_CD,'KRINC',20,'KRPUS',30,'KRKAN',62,'KRPTK',16,'KRUSN',110,0),'T',DECODE(KT.TS_POD_CD,'KRINC',20,'KRPUS',30,'KRKAN',62,'KRPTK',16,'KRUSN',110,0),DECODE(KT.TS_POL_CD,'KRINC',20,'KRPUS',30,'KRKAN',62,'KRPTK',16,'KRUSN',110,0)),TO_NUMBER(NVL(KT.CSTMS_OFC_CTY_CD,'0'))) CSTMS_OFC_CTY_CD" ).append("\n"); 
		query.append("     , DECODE(TO_NUMBER(NVL(KT.KR_CSTMS_DEPT_CD,'0')),0,DECODE(@[cstms_decl_tp_cd],'I',DECODE(KT.TS_POD_CD,'KRINC',10,'KRPUS',10,'KRKAN',10,'KRPTK',10,'KRUSN',10,0), 'T',DECODE(KT.TS_POD_CD,'KRINC',10,'KRPUS',10,'KRKAN',10,'KRPTK',10,'KRUSN',10,0), DECODE(KT.TS_POL_CD,'KRINC',10,'KRPUS',10,'KRKAN',10,'KRPTK',10,'KRUSN',10,0)),TO_NUMBER(NVL(KT.KR_CSTMS_DEPT_CD,'0'))) KR_CSTMS_DEPT_CD" ).append("\n"); 
		query.append("     , KT.DMST_PORT_CD DMST_PORT_CD" ).append("\n"); 
		query.append("     , KT.CMDT_CD CMDT_CD" ).append("\n"); 
		query.append("     , KT.KR_MEAS_UT_CD KR_MEAS_UT_CD" ).append("\n"); 
		query.append("     , NVL(KT.BIZ_RGST_NO,@[biz_no]) BIZ_RGST_NO" ).append("\n"); 
		query.append("     , KT.BB_CGO_WGT BB_CGO_WGT" ).append("\n"); 
		query.append("     , KT.BB_CGO_MEAS_QTY BB_CGO_MEAS_QTY" ).append("\n"); 
		query.append("     , KC.AMDT_RCVR_CD AMDT_RCVR_FLG" ).append("\n"); 
		query.append("     , @[mrn_no] MRN_NO" ).append("\n"); 
		query.append("     , @[vsl_call_sgn_cd] VSL_CALL_SGN_CD" ).append("\n"); 
		query.append("     , @[eta_dt] ETA_DT" ).append("\n"); 
		query.append("     , @[call_knt] CALL_KNT" ).append("\n"); 
		query.append("     , @[vsl_nm] VSL_NM" ).append("\n"); 
		query.append("     , @[vsl_cnt_cd] VSL_CNT_CD" ).append("\n"); 
		query.append("     , '2' DCHG_MZD_CD" ).append("\n"); 
		query.append("     , @[io_tml_loc_cd] IO_TML_LOC_CD" ).append("\n"); 
		query.append("     , DECODE(@[cstms_decl_tp_cd],'I',DECODE(TO_NUMBER(NVL(KT.KR_PORT_AUTH_CD,'0')),0,DECODE(KT.TS_POD_CD,'KRPUS',20,'KRINC',30,'KRKAN',622,'KRPTK',31,'KRUSN',820,0),TO_NUMBER(NVL(KT.KR_PORT_AUTH_CD,'0'))),'T',DECODE(TO_NUMBER(NVL(KT.KR_PORT_AUTH_CD,'0')),0,DECODE(KT.TS_POD_CD,'KRPUS',20,'KRINC',30,'KRKAN',622,'KRPTK',31,'KRUSN',820,0),TO_NUMBER(NVL(KT.KR_PORT_AUTH_CD,'0'))),DECODE(TO_NUMBER(NVL(KT.KR_PORT_AUTH_CD,'0')),0,DECODE(KT.TS_POL_CD,'KRPUS',20,'KRINC',30,'KRKAN',622,'KRPTK',31,'KRUSN',820,0),TO_NUMBER(NVL(KT.KR_PORT_AUTH_CD,'0')))) KR_PORT_AUTH_CD" ).append("\n"); 
		query.append("     , KT.DELT_FLG DELT_FLG" ).append("\n"); 
		query.append("	 , KT.CGO_TRSP_CD CGO_TRSP_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_BL KT, BKG_CSTMS_KR_CORR KC" ).append("\n"); 
		query.append(" WHERE KT.CSTMS_BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("   AND KT.CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("   AND KT.DMST_PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("   AND KT.TRNS_SEQ         = (SELECT NVL(MAX(TRNS_SEQ),1)" ).append("\n"); 
		query.append("                		 	     FROM   BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("                			     WHERE  CSTMS_BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("                			     AND    DMST_PORT_CD     = @[port_cd]" ).append("\n"); 
		query.append("                			     AND    CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd])" ).append("\n"); 
		query.append("   AND KT.BKG_NO           = KC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND KT.CSTMS_DECL_TP_CD = KC.CSTMS_DECL_TP_CD(+)" ).append("\n"); 
		query.append("   AND KT.DMST_PORT_CD     = KC.PORT_CD(+)" ).append("\n"); 
		query.append("   AND KC.AMDT_SND_DT(+) IS NULL " ).append("\n"); 
		query.append("   AND NVL(KT.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append(" ORDER BY KC.UPD_DT DESC, SMT_AMD_NO DESC" ).append("\n"); 

	}
}