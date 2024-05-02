/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OtherSOManageDBDAOAddTrsSvcOrdCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OtherSOManageDBDAOAddTrsSvcOrdCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CREATE Other S/O
	  * </pre>
	  */
	public OtherSOManageDBDAOAddTrsSvcOrdCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEGO_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CUST_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FUEL_SCG_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ETC_ADD_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_OFC_CTY_CD_",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_CRR_MOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_AGMT_OFC_CTY_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TOLL_FEE_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTC_PSON_PHN_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_STS_CD_",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_AGMT_WY_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DOR_DE_ADDR",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TO_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CMDT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("REF_BKG_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_AGMT_RT_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_BND_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ACT_CUST_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("COST_MODE",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_USR_OFC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_OTR_COST_MON_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VIA_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_SEQ_",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_AGMT_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTC_PSON_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EQ_KND_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_PURP_RSN",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EQ_TPSZ_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_COST_DTL_MOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CURR_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LNK_DIST_DIV_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CUST_NOMI_TRKR_FLG",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TTL_DIST",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ACT_CUST_ADDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("REF_BL_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CGO_TP_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CUST_CNT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("NEGO_RMK",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WGT_MEAS_UT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BZC_AMT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FM_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EQ_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTC_PSON_FAX_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WTR_DE_TERM_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FCTRY_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WTR_RCV_TERM_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FORM_CRE_USR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRSP_SO_TP_CD_",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ACT_CUST_CNT_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VNDR_SEQ",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DOR_NOD_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTR_WGT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.integration").append("\n"); 
		query.append("FileName : OtherSOManageDBDAOAddTrsSvcOrdCSQL").append("\n"); 
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
		query.append("INSERT INTO TRS_TRSP_SVC_ORD (						" ).append("\n"); 
		query.append("	EQ_NO											,	" ).append("\n"); 
		query.append("	EQ_TPSZ_CD										,	" ).append("\n"); 
		query.append("	TRSP_BND_CD										,	" ).append("\n"); 
		query.append("	CGO_TP_CD										,	" ).append("\n"); 
		query.append("	CNTR_WGT										,	" ).append("\n"); 
		query.append("	WGT_MEAS_UT_CD									,	" ).append("\n"); 
		query.append("	CNTR_KGS_WGT									,	" ).append("\n"); 
		query.append("	CNTR_LBS_WGT									,	" ).append("\n"); 
		query.append("	TRSP_COST_DTL_MOD_CD							,	" ).append("\n"); 
		query.append("	TRSP_CRR_MOD_CD									,	" ).append("\n"); 
		query.append("	CMDT_CD											,	" ).append("\n"); 
		query.append("	CUST_NOMI_TRKR_FLG								,	" ).append("\n"); 
		query.append("	CUST_CNT_CD										,	" ).append("\n"); 
		query.append("	CUST_SEQ										,	" ).append("\n"); 
		query.append("	TRSP_OTR_COST_MON_DT							,	" ).append("\n"); 
		query.append("	FM_NOD_CD										,	" ).append("\n"); 
		query.append("	VIA_NOD_CD										,	" ).append("\n"); 
		query.append("	TO_NOD_CD										,	" ).append("\n"); 
		query.append("	DOR_NOD_CD										,	" ).append("\n"); 
		query.append("	DOR_DE_ADDR										," ).append("\n"); 
		query.append("    VSL_CD											," ).append("\n"); 
		query.append("    SKD_VOY_NO										," ).append("\n"); 
		query.append("	SKD_DIR_CD										,	" ).append("\n"); 
		query.append("	VNDR_SEQ										,	" ).append("\n"); 
		query.append("	CURR_CD											,	" ).append("\n"); 
		query.append("	BZC_AMT											,	" ).append("\n"); 
		query.append("	NEGO_AMT										,	" ).append("\n"); 
		query.append("	FUEL_SCG_AMT									," ).append("\n"); 
		query.append("	TOLL_FEE_AMT									,	" ).append("\n"); 
		query.append("	ETC_ADD_AMT										,	" ).append("\n"); 
		query.append("	REF_BKG_NO										,	" ).append("\n"); 
		query.append("	REF_BL_NO										,	" ).append("\n"); 
		query.append("	TRSP_PURP_RSN									,	" ).append("\n"); 
		query.append("	TRSP_SO_OFC_CTY_CD								,	" ).append("\n"); 
		query.append("	TRSP_SO_SEQ										,	" ).append("\n"); 
		query.append("	TRSP_SO_TP_CD									,	" ).append("\n"); 
		query.append("	TRSP_SO_STS_CD									,	" ).append("\n"); 
		query.append("	EQ_KND_CD										,	" ).append("\n"); 
		query.append("	TRSP_AGMT_RT_TP_CD								,	" ).append("\n"); 
		query.append("	TRSP_AGMT_WY_TP_CD								,	" ).append("\n"); 
		query.append("	TRSP_AGMT_OFC_CTY_CD							,	" ).append("\n"); 
		query.append("	TRSP_AGMT_SEQ									,	" ).append("\n"); 
		query.append("	ACT_CUST_CNT_CD									,	" ).append("\n"); 
		query.append("	ACT_CUST_SEQ									,	" ).append("\n"); 
		query.append("	ACT_CUST_ADDR_SEQ								,	" ).append("\n"); 
		query.append("	FCTRY_NM										,	" ).append("\n"); 
		query.append("	CNTC_PSON_NM									,	" ).append("\n"); 
		query.append("	CNTC_PSON_PHN_NO								,	" ).append("\n"); 
		query.append("	CNTC_PSON_FAX_NO								,	" ).append("\n"); 
		query.append("	ACCT_CD											,	" ).append("\n"); 
		query.append("	LGS_COST_CD										,	" ).append("\n"); 
		query.append("	CRE_OFC_CD										,	" ).append("\n"); 
		query.append("	CRE_USR_ID										,	" ).append("\n"); 
		query.append("	CRE_DT											,	" ).append("\n"); 
		query.append("	UPD_USR_ID										,	" ).append("\n"); 
		query.append("	UPD_DT											," ).append("\n"); 
		query.append("	LOCL_CRE_DT										," ).append("\n"); 
		query.append("	LOCL_UPD_DT										," ).append("\n"); 
		query.append("	DELT_FLG                                        ," ).append("\n"); 
		query.append("    WTR_RCV_TERM_CD                                 ," ).append("\n"); 
		query.append("	WTR_DE_TERM_CD									," ).append("\n"); 
		query.append("	TTL_DIST										," ).append("\n"); 
		query.append("	LNK_DIST_DIV_CD									," ).append("\n"); 
		query.append("	NEGO_RMK" ).append("\n"); 
		query.append(" )VALUES (												" ).append("\n"); 
		query.append("	@[EQ_NO]										,	" ).append("\n"); 
		query.append("	@[EQ_TPSZ_CD]									,	" ).append("\n"); 
		query.append("	@[TRSP_BND_CD]									,	" ).append("\n"); 
		query.append("	@[CGO_TP_CD]									,	" ).append("\n"); 
		query.append("	@[CNTR_WGT]										,	" ).append("\n"); 
		query.append("	@[WGT_MEAS_UT_CD]								,	" ).append("\n"); 
		query.append("	TRS_COMMON_PKG.GET_CONV_WGT_TO_KGS_FNC(@[WGT_MEAS_UT_CD], @[CNTR_WGT])	,	" ).append("\n"); 
		query.append("	TRS_COMMON_PKG.GET_CONV_WGT_TO_LBS_FNC(@[WGT_MEAS_UT_CD], @[CNTR_WGT])	," ).append("\n"); 
		query.append("	@[TRSP_COST_DTL_MOD_CD]							,	" ).append("\n"); 
		query.append("	@[TRSP_CRR_MOD_CD]								,	" ).append("\n"); 
		query.append("	@[CMDT_CD]										,	" ).append("\n"); 
		query.append("	@[CUST_NOMI_TRKR_FLG]							,	" ).append("\n"); 
		query.append("	@[CUST_CNT_CD]									,	" ).append("\n"); 
		query.append("	@[CUST_SEQ]										,	" ).append("\n"); 
		query.append("	@[TRSP_OTR_COST_MON_DT]							,	" ).append("\n"); 
		query.append("	@[FM_NOD_CD]									,	" ).append("\n"); 
		query.append("	@[VIA_NOD_CD]									,	" ).append("\n"); 
		query.append("	@[TO_NOD_CD]									,	" ).append("\n"); 
		query.append("	@[DOR_NOD_CD]									,	" ).append("\n"); 
		query.append("	@[DOR_DE_ADDR]									,	" ).append("\n"); 
		query.append("	NVL(SUBSTR(TRS_COMMON_PKG.GET_BKG_REV_VVD3_FNC(@[FORM_USR_OFC_CD], TO_CHAR(SYSDATE,'YYYYMMDD'), @[TRSP_SO_TP_CD_], @[TRSP_SO_OFC_CTY_CD_], @[TRSP_SO_SEQ_], @[EQ_KND_CD], @[CGO_TP_CD], NULL, DECODE(@[REF_BKG_NO],NULL,@[REF_BL_NO],@[REF_BKG_NO]), NULL, NULL, NULL, @[TRSP_OTR_COST_MON_DT]),1,4),'CNTC')	," ).append("\n"); 
		query.append("	NVL(SUBSTR(TRS_COMMON_PKG.GET_BKG_REV_VVD3_FNC(@[FORM_USR_OFC_CD], TO_CHAR(SYSDATE,'YYYYMMDD'), @[TRSP_SO_TP_CD_], @[TRSP_SO_OFC_CTY_CD_], @[TRSP_SO_SEQ_], @[EQ_KND_CD], @[CGO_TP_CD], NULL, DECODE(@[REF_BKG_NO],NULL,@[REF_BL_NO],@[REF_BKG_NO]), NULL, NULL, NULL, @[TRSP_OTR_COST_MON_DT]),5,4),@[TRSP_OTR_COST_MON_DT])	," ).append("\n"); 
		query.append("	NVL(SUBSTR(TRS_COMMON_PKG.GET_BKG_REV_VVD3_FNC(@[FORM_USR_OFC_CD], TO_CHAR(SYSDATE,'YYYYMMDD'), @[TRSP_SO_TP_CD_], @[TRSP_SO_OFC_CTY_CD_], @[TRSP_SO_SEQ_], @[EQ_KND_CD], @[CGO_TP_CD], NULL, DECODE(@[REF_BKG_NO],NULL,@[REF_BL_NO],@[REF_BKG_NO]), NULL, NULL, NULL, @[TRSP_OTR_COST_MON_DT]),9,1),'M')	," ).append("\n"); 
		query.append("    @[VNDR_SEQ]										,	" ).append("\n"); 
		query.append("	@[CURR_CD]										,	" ).append("\n"); 
		query.append("	@[BZC_AMT]										,	" ).append("\n"); 
		query.append("	@[NEGO_AMT]										,	" ).append("\n"); 
		query.append("	@[FUEL_SCG_AMT]									," ).append("\n"); 
		query.append("    @[TOLL_FEE_AMT]									,		" ).append("\n"); 
		query.append("	@[ETC_ADD_AMT]									,	" ).append("\n"); 
		query.append("	@[REF_BKG_NO]									,	" ).append("\n"); 
		query.append("	@[REF_BL_NO]									,	" ).append("\n"); 
		query.append("	@[TRSP_PURP_RSN]								,	" ).append("\n"); 
		query.append("	@[TRSP_SO_OFC_CTY_CD_]							,	" ).append("\n"); 
		query.append("	@[TRSP_SO_SEQ_]									,	" ).append("\n"); 
		query.append("	@[TRSP_SO_TP_CD_]								,	" ).append("\n"); 
		query.append("	@[TRSP_SO_STS_CD_]								,	" ).append("\n"); 
		query.append("	@[EQ_KND_CD]									,	" ).append("\n"); 
		query.append("	@[TRSP_AGMT_RT_TP_CD]							,	" ).append("\n"); 
		query.append("	@[TRSP_AGMT_WY_TP_CD]							,	" ).append("\n"); 
		query.append("	@[TRSP_AGMT_OFC_CTY_CD]							,	" ).append("\n"); 
		query.append("	@[TRSP_AGMT_SEQ]								,	" ).append("\n"); 
		query.append("	@[ACT_CUST_CNT_CD]								,	" ).append("\n"); 
		query.append("	@[ACT_CUST_SEQ]									,	" ).append("\n"); 
		query.append("	@[ACT_CUST_ADDR_SEQ]							,	" ).append("\n"); 
		query.append("	@[FCTRY_NM]										,	" ).append("\n"); 
		query.append("	@[CNTC_PSON_NM]									,	" ).append("\n"); 
		query.append("	@[CNTC_PSON_PHN_NO]								,	" ).append("\n"); 
		query.append("	@[CNTC_PSON_FAX_NO]								,	" ).append("\n"); 
		query.append("	(													" ).append("\n"); 
		query.append("		SELECT B.ACCT_CD                				" ).append("\n"); 
		query.append("		FROM TES_LGS_COST B            					" ).append("\n"); 
		query.append("		WHERE B.LGS_COST_CD =	@[COST_MODE]   " ).append("\n"); 
		query.append("	)												,	" ).append("\n"); 
		query.append("	@[COST_MODE]									,	" ).append("\n"); 
		query.append("	@[FORM_USR_OFC_CD]								,	" ).append("\n"); 
		query.append("	@[FORM_CRE_USR_ID]								,	" ).append("\n"); 
		query.append("	SYSDATE											,	" ).append("\n"); 
		query.append("	@[FORM_CRE_USR_ID]								,	" ).append("\n"); 
		query.append("	SYSDATE											,	" ).append("\n"); 
		query.append("	GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC( @[FORM_USR_OFC_CD])	,	" ).append("\n"); 
		query.append("	GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC( @[FORM_USR_OFC_CD])	,	" ).append("\n"); 
		query.append("	'N'		                                        ," ).append("\n"); 
		query.append("    @[WTR_RCV_TERM_CD]                              ," ).append("\n"); 
		query.append("    @[WTR_DE_TERM_CD]								," ).append("\n"); 
		query.append("	@[TTL_DIST]										," ).append("\n"); 
		query.append("	@[LNK_DIST_DIV_CD]								," ).append("\n"); 
		query.append("	@[NEGO_RMK]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}