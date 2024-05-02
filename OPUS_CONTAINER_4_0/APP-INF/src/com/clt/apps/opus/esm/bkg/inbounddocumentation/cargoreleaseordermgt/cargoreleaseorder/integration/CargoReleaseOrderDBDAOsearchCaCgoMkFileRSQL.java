/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchCaCgoMkFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchCaCgoMkFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CargoReleaseOrderDBDAOsearchCaCgoMkFileRSQL
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchCaCgoMkFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("final_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_eta_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_cstms_clr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snp_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snp_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_eta_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_knd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_etd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_eta_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("init_etd_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_slan_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("final_eta_dt_gmt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dspo_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchCaCgoMkFileRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_ASC(F XPKBKG_CONTAINER) */" ).append("\n"); 
		query.append("       '$$$MSGSTART:'||RPAD(@[edi_snd_id],20)||RPAD(@[edi_rcv_id],20)||RPAD('TDC315',10) ||" ).append("\n"); 
		query.append("       'BKG'||TO_CHAR(SYSDATE,'YYMMDD')||LTRIM(TO_CHAR(BKG_DO_EDI_SEQ.NEXTVAL,'00009'),' ') || CHR(10) || " ).append("\n"); 
		query.append("       'MUID:'              || TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'USNYC'), 'yyyymmddhh24mi')  || CHR(10) ||" ).append("\n"); 
		query.append("       'SNDID:'             || @[edi_snd_id]                         || CHR(10) ||" ).append("\n"); 
		query.append("       'RCVID:'             || DECODE(@[edi_rcv_id],'PA','TRADIANT','PQ','TRADIANT',@[edi_rcv_id]) || CHR(10) ||" ).append("\n"); 
		query.append("       '322ID:'             || DECODE(CG.CSTMS_CLR_LST_DT,NULL,'',DECODE(CG.CSTMS_CLR_CD,'P','Y',CG.CSTMS_CLR_CD)) || CHR(10) ||" ).append("\n"); 
		query.append("       'MSGID:'             || @[edi_knd]                        || CHR(10) FLAT_FILE_HEADER," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       CASE WHEN EXISTS (SELECT ATTR_CTNT2 FROM BKG_CSTMS_CD_CONV_CTNT WHERE CNT_CD='CA' AND CSTMS_DIV_ID='US_CR_SNP_STUP' AND ATTR_CTNT1 = @[edi_rcv_id])" ).append("\n"); 
		query.append("       THEN" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("       '$$$MSGSTART:'||RPAD(ATTR_CTNT3,20)||RPAD(ATTR_CTNT2,20)||RPAD('TDC315',10)" ).append("\n"); 
		query.append("       FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("       WHERE CNT_CD='CA'" ).append("\n"); 
		query.append("       AND CSTMS_DIV_ID='US_CR_SNP_STUP'" ).append("\n"); 
		query.append("       AND ATTR_CTNT1 = @[edi_rcv_id]" ).append("\n"); 
		query.append("       )||'BKG'||TO_CHAR(SYSDATE,'YYMMDD')||LTRIM(TO_CHAR(BKG_DO_EDI_SEQ.NEXTVAL,'00009'),' ') || CHR(10) ||(" ).append("\n"); 
		query.append("       SELECT" ).append("\n"); 
		query.append("       'MUID:'              || TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'USNYC'), 'yyyymmddhh24mi')  || CHR(10) ||" ).append("\n"); 
		query.append("       'SNDID:'             || ATTR_CTNT3                         || CHR(10) ||" ).append("\n"); 
		query.append("       'RCVID:'             || DECODE(ATTR_CTNT2,'PA','TRADIANT','PQ','TRADIANT',ATTR_CTNT2) || CHR(10) ||" ).append("\n"); 
		query.append("       '322ID:'             || DECODE(CG.CSTMS_CLR_LST_DT,NULL,'',DECODE(@[new_cstms_clr_cd],'P','Y',@[new_cstms_clr_cd])) || CHR(10) ||" ).append("\n"); 
		query.append("       'MSGID:'             || @[edi_msg_id]                         || CHR(10)" ).append("\n"); 
		query.append("       FROM BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("       WHERE CNT_CD='CA'" ).append("\n"); 
		query.append("       AND CSTMS_DIV_ID='US_CR_SNP_STUP'" ).append("\n"); 
		query.append("       AND ATTR_CTNT1 = @[edi_rcv_id]" ).append("\n"); 
		query.append("       ) " ).append("\n"); 
		query.append("       ELSE ''" ).append("\n"); 
		query.append("       END DUP_FLAT_FILE_HEADER,  /* 6/28 추가 */" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       '$$$MSGSTART:'||RPAD(@[edi_snp_snd_id],20)||RPAD(@[edi_snp_rcv_id],20)||RPAD('TDC315',10) ||" ).append("\n"); 
		query.append("       'BKG'||TO_CHAR(SYSDATE,'YYMMDD')||LTRIM(TO_CHAR(BKG_DO_EDI_SEQ.NEXTVAL,'00009'),' ') || CHR(10) || " ).append("\n"); 
		query.append("       'MUID:'              || TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC,SYSDATE,'USNYC'), 'yyyymmddhh24mi')  || CHR(10) ||" ).append("\n"); 
		query.append("       'SNDID:'             || @[edi_snp_snd_id]                             || CHR(10) ||" ).append("\n"); 
		query.append("       'RCVID:'             || @[edi_snp_rcv_id] || CHR(10) ||" ).append("\n"); 
		query.append("       '322ID:'             || DECODE(CG.CSTMS_CLR_LST_DT,NULL,'',DECODE(@[new_cstms_clr_cd],'P','Y',@[new_cstms_clr_cd])) || CHR(10) ||" ).append("\n"); 
		query.append("       'MSGID:'             || @[edi_msg_id]                         || CHR(10) SNP_FILE_HEADER,  /* 추가 Inalnd 에 보낼때 사용 */" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       'VIP_GRP_ID:'                                               || chr(10) ||" ).append("\n"); 
		query.append("	   'BL_NBR:'            || @[bl_no]		                     || chr(10) ||" ).append("\n"); 
		query.append("	   'BKG_NBR:'           || B.BKG_NO                            || chr(10) ||" ).append("\n"); 
		query.append("	   'TO_VSL_CODE:'       || VVD.VSL_CD                            || chr(10) ||" ).append("\n"); 
		query.append("	   'TO_VOYAGE:'         || VVD.SKD_VOY_NO                        || chr(10) ||" ).append("\n"); 
		query.append("	   'TO_DIR:'            || VVD.SKD_DIR_CD                        || chr(10) ||" ).append("\n"); 
		query.append("       'TO_CONSORT_VOY:'    || NVL(X.IB_CSSM_VOY_NO, ' ')          || CHR(10) ||" ).append("\n"); 
		query.append("	   'VSL_NAME:'          || NVL(C.VSL_ENG_NM, ' ')              || chr(10) ||" ).append("\n"); 
		query.append("	   'VSL_CNTR_CODE:'     || NVL(C.VSL_RGST_CNT_CD, ' ')         || chr(10) ||" ).append("\n"); 
		query.append("       'POR_NAME:'          || LA.LOC_NM                           || chr(10) ||" ).append("\n"); 
		query.append("       'POR_CODE:'          || LA.LOC_CD                           || chr(10) ||" ).append("\n"); 
		query.append("       'POR_AMSQUAL:'       || DECODE(LA.CNT_CD, 'CA', 'D', 'K')   || chr(10) ||" ).append("\n"); 
		query.append("       'POR_AMSPORT:'       || LA.LOC_AMS_PORT_CD                  || chr(10) ||" ).append("\n"); 
		query.append("       'PORETD:'                                                   || chr(10) ||" ).append("\n"); 
		query.append("       'PORETD_GMT:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'PORATD:'                                                   || chr(10) ||" ).append("\n"); 
		query.append("       'PORATD_GMT:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'POL_NAME:'          || LB.LOC_NM                           || chr(10) ||" ).append("\n"); 
		query.append("       'POL_CODE:'          || LB.LOC_CD                           || chr(10) ||" ).append("\n"); 
		query.append("       'POL_AMSQUAL:'       || DECODE(LB.CNT_CD, 'CA', 'D', 'K')   || chr(10) ||" ).append("\n"); 
		query.append("       'POL_AMSPORT:'       || LB.LOC_AMS_PORT_CD                  || chr(10) ||" ).append("\n"); 
		query.append("       'POLETA:'                                                   || chr(10) ||" ).append("\n"); 
		query.append("       'POLETA_GMT:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'POLATA:'                                                   || chr(10) ||" ).append("\n"); 
		query.append("       'POLATA_GMT:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'POLETD:'            || @[vps_etd_dt]                         || chr(10) ||" ).append("\n"); 
		query.append("       'POLETD_GMT:'        || @[vps_etd_dt_gmt]                      || chr(10) ||" ).append("\n"); 
		query.append("       'POLATD:'            || @[init_etd_dt]                        || chr(10) ||" ).append("\n"); 
		query.append("       'POLATD_GMT:'        || @[init_etd_dt_gmt]                     || chr(10) ||" ).append("\n"); 
		query.append("       'POD_NAME:'          || LC.LOC_NM                           || chr(10) ||" ).append("\n"); 
		query.append("       'POD_CODE:'          || LC.LOC_CD                           || chr(10) ||" ).append("\n"); 
		query.append("       'POD_AMSQUAL:'       || decode(LC.CNT_CD, 'CA', 'D', 'K')   || chr(10) ||" ).append("\n"); 
		query.append("       'POD_AMSPORT:'       || LC.LOC_AMS_PORT_CD                  || chr(10) ||" ).append("\n"); 
		query.append("       'PODETA:'            || @[vps_eta_dt]                         || chr(10) ||" ).append("\n"); 
		query.append("       'PODETA_GMT:'        || @[vps_eta_dt_gmt]                      || chr(10) ||" ).append("\n"); 
		query.append("       'PODATA:'            || @[init_eta_dt]                        || chr(10) ||" ).append("\n"); 
		query.append("       'PODATA_GMT:'        || @[init_eta_dt_gmt]                     || chr(10) ||" ).append("\n"); 
		query.append("       'PODETD:'                                                   || chr(10) ||" ).append("\n"); 
		query.append("       'PODETD_GMT:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'PODATD:'                                                   || chr(10) ||" ).append("\n"); 
		query.append("       'PODATD_GMT:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'DEL_NAME:'          || LD.LOC_NM                           || chr(10) ||" ).append("\n"); 
		query.append("       'DEL_CODE:'          || LD.LOC_CD                           || chr(10) ||" ).append("\n"); 
		query.append("       'DEL_AMSQUAL:'       || decode(LD.CNT_CD, 'CA', 'D', 'K')   || chr(10) ||" ).append("\n"); 
		query.append("       'DEL_AMSPORT:'       || LD.LOC_AMS_PORT_CD                  || chr(10) ||" ).append("\n"); 
		query.append("       'DELETA:'            || NVL(@[final_eta_dt], '')                || chr(10) ||" ).append("\n"); 
		query.append("       'DELETA_GMT:'        || NVL(@[final_eta_dt_gmt], '')             || chr(10) ||" ).append("\n"); 
		query.append("       'DELATA:'                                                   || chr(10) ||" ).append("\n"); 
		query.append("       'DELATA_GMT:'                                               || chr(10) ||" ).append("\n"); 
		query.append("       'RLY_NAME:'                                                 || chr(10) ||" ).append("\n"); 
		query.append("       'RLY_CODE:'                                                 || chr(10) ||" ).append("\n"); 
		query.append("       'RLY_AMSQUAL:'                                              || chr(10) ||" ).append("\n"); 
		query.append("       'RLY_AMSPORT:'                                              || chr(10) ||" ).append("\n"); 
		query.append("       'W_UNIT:'            || BD.WGT_UT_CD                         || chr(10) ||" ).append("\n"); 
		query.append("       'WEIGHT:'            || BD.ACT_WGT                           || chr(10) ||" ).append("\n"); 
		query.append("       'P_UNIT:'            || BD.PCK_TP_CD                        || chr(10) ||" ).append("\n"); 
		query.append("       'PACKAGE:'           || BD.PCK_QTY                           || chr(10) ||" ).append("\n"); 
		query.append("       'CNTR_NBR:'          || F.CNTR_NO                           || chr(10) ||" ).append("\n"); 
		query.append("       'CNTR_TYPE:'         || F.CNTR_TPSZ_CD                      || chr(10) ||" ).append("\n"); 
		query.append("       'F/M_IND:'           || DECODE(B.BKG_CGO_TP_CD, 'F', 'F', 'M') || chr(10) ||" ).append("\n"); 
		query.append("       'EVENT_DATE:'        || TO_CHAR(SYSDATE, 'yyyymmddhh24mi')  || chr(10) ||" ).append("\n"); 
		query.append("       'EVENT_DATE_GMT:'    || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',SYSDATE,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || chr(10) ||" ).append("\n"); 
		query.append("       'CUST_REF_NO:'       || NVL(T.CUST_REF_NO_CTNT, ' ')        || chr(10) ||" ).append("\n"); 
		query.append("	   'LLOYD_CODE:'        || NVL(C.LLOYD_NO, ' ')                || chr(10) ||" ).append("\n"); 
		query.append("	   'EVENT_LOC:'         || ' '					             || chr(10) ||" ).append("\n"); 
		query.append("	   'EVENT_LOC_NAME:'    || ' '				                 || chr(10) ||" ).append("\n"); 
		query.append("	   'EVENT_LOC_AMSQUAL:' || 'K'							     || chr(10) ||" ).append("\n"); 
		query.append("	   'EVENT_LOC_AMSPORT:' || ' '         						 || chr(10) ||" ).append("\n"); 
		query.append("	   'PO_NBR:'            || @[po_no]                            || chr(10) ||" ).append("\n"); 
		query.append("	   'BL_PO_NBR:'         || NVL(M.CUST_REF_NO_CTNT, '')         || chr(10) ||" ).append("\n"); 
		query.append("	   'CNTR_PO_NBR:'       || NVL(M.CUST_REF_NO_CTNT, '')         || chr(10) ||" ).append("\n"); 
		query.append("	   'BL_STORE_NBR:'                                             || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPRCODE:'          || CS.CUST_CNT_CD || LPAD(CS.CUST_SEQ, 6, 0) || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPR1:'             || BKG_TOKEN_NL_FNC(CS.CUST_NM, 1, '')     || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPR2:'             || BKG_TOKEN_NL_FNC(CS.CUST_NM, 2, '')     || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPR3:'             || BKG_TOKEN_NL_FNC(CS.CUST_ADDR, 1, '')   || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPR4:'             || BKG_TOKEN_NL_FNC(CS.CUST_ADDR, 2, '')   || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPR5:'             || BKG_TOKEN_NL_FNC(CS.CUST_ADDR, 3, '')   || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPR_CITY_NM:'	  || CS.CUST_CTY_NM                      || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPR_STAT_CD:'	  || CS.CUST_STE_CD                      || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPR_ZIP_CD:'	      || CS.CUST_ZIP_ID                      || chr(10) ||" ).append("\n"); 
		query.append("	   'SHPR_CNT_CD:'	      || CS.CSTMS_DECL_CNT_CD                || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEECODE:'          || CC.CUST_CNT_CD || LPAD(CC.CUST_SEQ, 6, 0) || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEE1:'             || BKG_TOKEN_NL_FNC(CC.CUST_NM, 1, '')     || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEE2:'             || BKG_TOKEN_NL_FNC(CC.CUST_NM, 2, '')     || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEE3:'             || BKG_TOKEN_NL_FNC(CC.CUST_ADDR, 1, '')   || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEE4:'             || BKG_TOKEN_NL_FNC(CC.CUST_ADDR, 2, '')   || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEE5:'             || BKG_TOKEN_NL_FNC(CC.CUST_ADDR, 3, '')   || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEE_CITY_NM:'	  || CC.CUST_CTY_NM                      || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEE_STAT_CD:'	  || CC.CUST_STE_CD                      || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEE_ZIP_CD:'	      || CC.CUST_ZIP_ID                      || chr(10) ||" ).append("\n"); 
		query.append("	   'CNEE_CNT_CD:'	      || CC.CSTMS_DECL_CNT_CD                || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFYCODE:'          || CN.CUST_CNT_CD || LPAD(CN.CUST_SEQ, 6, 0) || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFY1:'             || BKG_TOKEN_NL_FNC(CN.CUST_NM, 1, '')     || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFY2:'             || BKG_TOKEN_NL_FNC(CN.CUST_NM, 2, '')     || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFY3:'             || BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 1, '')   || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFY4:'             || BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 2, '')   || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFY5:'             || BKG_TOKEN_NL_FNC(CN.CUST_ADDR, 3, '')   || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFY_CITY_NM:'	  || CN.CUST_CTY_NM                      || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFY_STAT_CD:'	  || CN.CUST_STE_CD                      || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFY_ZIP_CD:'	      || CN.CUST_ZIP_ID                      || chr(10) ||" ).append("\n"); 
		query.append("	   'NTFY_CNT_CD:'	      || CN.CSTMS_DECL_CNT_CD                || chr(10) ||" ).append("\n"); 
		query.append("	   'REF_CUSTCODE:'      || DECODE(SUBSTR(@[edi_rcv_id], 1, 3), 'MTC', NVL(B.CND_CSTMS_FILE_CD, ''), 'TTI', NVL(B.CND_CSTMS_FILE_CD, ''), 'GPA', NVL(B.CND_CSTMS_FILE_CD, ''), 'MAH', NVL(B.CND_CSTMS_FILE_CD, ''), NVL(@[cust_cd], '')) || chr(10) ||" ).append("\n"); 
		query.append("	   'INV_NBR:'           || DECODE(SUBSTR(@[edi_rcv_id], 1, 3), 'MTC', @[cstms_dspo_cd], 'TTI', @[cstms_dspo_cd], 'GPA', @[cstms_dspo_cd], 'MAH', @[cstms_dspo_cd], 'TRA', @[cstms_dspo_cd], NVL(O.CUST_REF_NO_CTNT, '')) || chr(10) ||" ).append("\n"); 
		query.append("	   'RD_TERM:'           || B.RCV_TERM_CD || B.DE_TERM_CD       || chr(10) ||" ).append("\n"); 
		query.append("	   'CUST_EDATE:'        || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI')  || chr(10) ||" ).append("\n"); 
		query.append("	   'CUST_EDATE_GMT:'    || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',SYSDATE,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || chr(10) ||" ).append("\n"); 
		query.append("	   'CUST_ADATE:'        || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MI')  || chr(10) ||" ).append("\n"); 
		query.append("	   'CUST_ADATE_GMT:'    || NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('USNYC',SYSDATE,'GMT' ), 'YYYYMMDDHH24MI'), ' ') || chr(10) ||" ).append("\n"); 
		query.append("	   'CURRENT_VVD:'       || VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD || chr(10) ||" ).append("\n"); 
		query.append("       'CONSORT_VOY:'       || NVL(X.IB_CSSM_VOY_NO, ' ')          || CHR(10) ||" ).append("\n"); 
		query.append("       'SEL_NBR:'           || NVL(G.CNTR_SEAL_NO, ' ')                 || chr(10) ||" ).append("\n"); 
		query.append("       'LANE:'              || NVL(B.SLAN_CD, '')                  || chr(10) ||" ).append("\n"); 
		query.append("	   'LANE_DESC:'         || @[vsl_slan_nm]		                     || chr(10) ||" ).append("\n"); 
		query.append("	   'SC_NBR:'            || NVL(B.SC_NO, '')                    || chr(10) ||" ).append("\n"); 
		query.append("	   'IT_NBR:'                                                   || CHR(10) ||" ).append("\n"); 
		query.append("	   'PICKUP_NBR:'                                               || CHR(10) FLAT_FILE_BODY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("       BKG_BOOKING      B," ).append("\n"); 
		query.append("       BKG_REFERENCE    O," ).append("\n"); 
		query.append("       MDM_VSL_CNTR     C," ).append("\n"); 
		query.append("       BKG_REFERENCE    M," ).append("\n"); 
		query.append("       BKG_CUSTOMER     CS," ).append("\n"); 
		query.append("       BKG_CUSTOMER     CC," ).append("\n"); 
		query.append("       BKG_CUSTOMER     CN," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       BKG_REFERENCE    T," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       MDM_LOCATION     LA," ).append("\n"); 
		query.append("       MDM_LOCATION     LB," ).append("\n"); 
		query.append("       MDM_LOCATION     LC," ).append("\n"); 
		query.append("       MDM_LOCATION     LD," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       BKG_CONTAINER    F," ).append("\n"); 
		query.append("       BKG_CNTR_SEAL_NO G," ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("       BKG_BL_DOC       BD," ).append("\n"); 
		query.append("       BKG_CGO_RLSE     CG," ).append("\n"); 
		query.append("       VSK_VSL_PORT_SKD X," ).append("\n"); 
		query.append("       (SELECT *" ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("                SELECT BV.* , " ).append("\n"); 
		query.append("                       ROW_NUMBER() OVER (PARTITION BY BV.BKG_NO ORDER BY BV.VSL_PRE_PST_CD, BV.VSL_SEQ ) ROW_NUMBER" ).append("\n"); 
		query.append("                FROM BKG_VVD BV, BKG_BOOKING BK" ).append("\n"); 
		query.append("                WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("                  AND BK.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                  AND BV.POD_CD LIKE 'CA%'" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("         ) VVD      " ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND B.BL_NO              = @[bl_no]  " ).append("\n"); 
		query.append("   AND B.BKG_NO             = O.BKG_NO(+)" ).append("\n"); 
		query.append("   AND O.BKG_REF_TP_CD(+)   = 'HINV'" ).append("\n"); 
		query.append("   AND VVD.VSL_CD           = C.VSL_CD" ).append("\n"); 
		query.append("   AND B.BKG_NO             = M.BKG_NO(+)" ).append("\n"); 
		query.append("   AND M.BKG_REF_TP_CD(+)   = 'BKPO'" ).append("\n"); 
		query.append("   AND B.BKG_NO             = CS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CS.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("   AND B.BKG_NO             = CC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CC.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("   AND B.BKG_NO             = CN.BKG_NO(+)" ).append("\n"); 
		query.append("   AND CN.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("   AND B.BKG_NO 			= VVD.BKG_NO" ).append("\n"); 
		query.append("   AND 1 = VVD.ROW_NUMBER" ).append("\n"); 
		query.append("   AND B.BKG_NO             = T.BKG_NO(+)" ).append("\n"); 
		query.append("   AND T.BKG_REF_TP_CD(+)   = 'EBRF'	" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.POR_CD             = LA.LOC_CD(+)" ).append("\n"); 
		query.append("   AND B.POL_CD		        = LB.LOC_CD(+)" ).append("\n"); 
		query.append("   AND B.POD_CD		        = LC.LOC_CD(+)" ).append("\n"); 
		query.append("   AND B.DEL_CD	            = LD.LOC_CD(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.BKG_NO              = F.BKG_NO(+)" ).append("\n"); 
		query.append("   AND F.BKG_NO              = G.BKG_NO(+)" ).append("\n"); 
		query.append("   AND F.CNTR_NO            = G.CNTR_NO(+)" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   AND B.BKG_NO             = BD.BKG_NO" ).append("\n"); 
		query.append("   AND B.BL_NO              = CG.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND VVD.VSL_CD             = X.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO         = X.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD         = X.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND VVD.POD_CD             = X.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("   AND X.CLPT_IND_SEQ(+) = '1'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${edi_bl_cntr_ind} == 'B') " ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}