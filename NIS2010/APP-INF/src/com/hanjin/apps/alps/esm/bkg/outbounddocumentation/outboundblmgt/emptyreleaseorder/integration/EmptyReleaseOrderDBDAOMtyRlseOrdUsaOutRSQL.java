/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EmptyReleaseOrderDBDAOMtyRlseOrdUsaOutRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EmptyReleaseOrderDBDAOMtyRlseOrdUsaOutRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public EmptyReleaseOrderDBDAOMtyRlseOrdUsaOutRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pi_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("full_rtn_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("end_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pkup_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.integration").append("\n"); 
		query.append("FileName : EmptyReleaseOrderDBDAOMtyRlseOrdUsaOutRSQL").append("\n"); 
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
		query.append("SELECT A2.USA_SEQ" ).append("\n"); 
		query.append(",A2.COL_CHK" ).append("\n"); 
		query.append(",A2.BKG_NO" ).append("\n"); 
		query.append(",A2.BKG_STS_CD" ).append("\n"); 
		query.append(",A2.RCV_TERM_CD" ).append("\n"); 
		query.append(",A2.DE_TERM_CD" ).append("\n"); 
		query.append(",A2.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",A2.SCC_CD" ).append("\n"); 
		query.append(",A2.TVVD" ).append("\n"); 
		query.append(",A2.POR_CD" ).append("\n"); 
		query.append(",A2.MTY_PKUP_DT" ).append("\n"); 
		query.append(",A2.POL_CD" ).append("\n"); 
		query.append(",TO_CHAR(A2.LODG_DUE_DT, 'YYYY-MM-DD') AS LODG_DUE_DT" ).append("\n"); 
		query.append(",A2.IP" ).append("\n"); 
		query.append(",A2.YARD_TYPE" ).append("\n"); 
		query.append(",A2.YARD" ).append("\n"); 
		query.append(",DECODE(A3.NTC_FAX_NO, '', A1.FAX_NO, A3.NTC_FAX_NO) AS NTC_FAX_NO" ).append("\n"); 
		query.append(",DECODE(A3.NTC_EML, '', A1.YD_EML, A3.NTC_EML) AS NTC_EML" ).append("\n"); 
		query.append(",A2.EDI_ID" ).append("\n"); 
		query.append(",DECODE(A2.YARD, '', '', A3.FAX_SND_DT) AS FAX_SND_DT" ).append("\n"); 
		query.append(",DECODE(A2.YARD, '', '', A3.EML_SND_DT) AS EML_SND_DT" ).append("\n"); 
		query.append(",DECODE(A2.YARD, '', '', A3.EDI_SND_DT) AS EDI_SND_DT" ).append("\n"); 
		query.append(",DECODE(A2.YARD, '', '', A4.INTG_CD_VAL_DP_DESC) AS FAX_SND_RSLT_CD" ).append("\n"); 
		query.append(",DECODE(A2.YARD, '', '', A5.INTG_CD_VAL_DP_DESC) AS EML_SND_RSLT_CD" ).append("\n"); 
		query.append(",DECODE(A2.YARD, '', '', A4.INTG_CD_VAL_DESC) AS FAX_SND_RSLT_NM" ).append("\n"); 
		query.append(",DECODE(A2.YARD, '', '', A5.INTG_CD_VAL_DESC) AS EML_SND_RSLT_NM" ).append("\n"); 
		query.append(",A3.DIFF_RMK" ).append("\n"); 
		query.append("FROM MDM_YARD A1" ).append("\n"); 
		query.append(",(SELECT DENSE_RANK() OVER(ORDER BY BKG.BKG_NO) AS USA_SEQ" ).append("\n"); 
		query.append(",ROW_NUMBER() OVER(PARTITION BY BKG.BKG_NO ORDER BY ROWNUM) AS COL_CHK" ).append("\n"); 
		query.append(",BKG.BKG_NO" ).append("\n"); 
		query.append(",BKG.BKG_STS_CD" ).append("\n"); 
		query.append(",BKG.RCV_TERM_CD" ).append("\n"); 
		query.append(",BKG.DE_TERM_CD" ).append("\n"); 
		query.append(",LOC.EQ_CTRL_OFC_CD" ).append("\n"); 
		query.append(",LOC.SCC_CD" ).append("\n"); 
		query.append(",BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS TVVD" ).append("\n"); 
		query.append(",BKG.POR_CD" ).append("\n"); 
		query.append(",TO_CHAR(BKG.MTY_PKUP_DT,'YYYY-MM-DD') AS MTY_PKUP_DT" ).append("\n"); 
		query.append(",BKG.POL_CD" ).append("\n"); 
		query.append(",BKG.LODG_DUE_DT" ).append("\n"); 
		query.append(",DECODE(BKG.POR_CD, BKG.POL_CD, 'P' ,'I') AS IP" ).append("\n"); 
		query.append(",DECODE(MFT.YARD_TYPE, 'F', DECODE(BKG.FULL_RTN_YD_CD, BKG.POL_NOD_CD, 'F/T', 'F')" ).append("\n"); 
		query.append(", 'T', DECODE(BKG.FULL_RTN_YD_CD, BKG.POL_NOD_CD, 'F/T', 'T')" ).append("\n"); 
		query.append(", MFT.YARD_TYPE) AS YARD_TYPE" ).append("\n"); 
		query.append(",(SELECT EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("-- 'BT'" ).append("\n"); 
		query.append("FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append(", BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append(", BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO   = BKG.BKG_NO" ).append("\n"); 
		query.append("AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_TP_ID      = '301'" ).append("\n"); 
		query.append("AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("AND EY.PRNR_SUB_LNK_CD = BK.POL_NOD_CD" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_IND_CD IN ('1', '2') -- BKG" ).append("\n"); 
		query.append("AND MFT.YARD_TYPE = 'T'" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT EDI_YD.YD_CD" ).append("\n"); 
		query.append("-- 'FC'" ).append("\n"); 
		query.append("FROM BKG_EDI_YD EDI_YD, BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.FULL_RTN_YD_CD = EDI_YD.YD_CD(+)" ).append("\n"); 
		query.append("AND BK.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND MFT.YARD_TYPE = 'F'" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("-- ,'CN'" ).append("\n"); 
		query.append("FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append(", BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append(", BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.MTY_PKUP_YD_CD = EY.PRNR_SUB_LNK_CD(+)" ).append("\n"); 
		query.append("AND 'Y'       = EY.EDI_SND_FLG(+)" ).append("\n"); 
		query.append("AND BK.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_TP_ID = '301'" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_IND_CD = '5'" ).append("\n"); 
		query.append("AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("AND MFT.YARD_TYPE = 'M'" ).append("\n"); 
		query.append("AND ROWNUM =1) AS YARD" ).append("\n"); 
		query.append(",(SELECT EY.RCVR_TRD_PRNR_ID AS EDI_RCV_ID" ).append("\n"); 
		query.append("-- ,EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("-- 'BT'" ).append("\n"); 
		query.append("FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append(", BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append(", BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.BKG_NO   = BKG.BKG_NO" ).append("\n"); 
		query.append("AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("AND EY.PRNR_SUB_LNK_DIV_CD = '1'" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_TP_ID      = '301'" ).append("\n"); 
		query.append("AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("AND EY.PRNR_SUB_LNK_CD = BK.POL_NOD_CD" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_IND_CD IN ('1', '2') -- BKG" ).append("\n"); 
		query.append("AND MFT.YARD_TYPE = 'T'" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT EDI_YD.EDI_RCV_ID EDI_ID" ).append("\n"); 
		query.append("-- 'FC'" ).append("\n"); 
		query.append("FROM BKG_EDI_YD EDI_YD, BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.FULL_RTN_YD_CD = EDI_YD.YD_CD(+)" ).append("\n"); 
		query.append("AND BK.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND MFT.YARD_TYPE = 'F'" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT EY.RCVR_TRD_PRNR_ID EDI_ID" ).append("\n"); 
		query.append("-- ,EY.PRNR_SUB_LNK_CD AS YD_CD" ).append("\n"); 
		query.append("-- ,'CN'" ).append("\n"); 
		query.append("FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append(", BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append(", BKG_BOOKING BK" ).append("\n"); 
		query.append("WHERE BK.MTY_PKUP_YD_CD = EY.PRNR_SUB_LNK_CD(+)" ).append("\n"); 
		query.append("AND 'Y'       = EY.EDI_SND_FLG(+)" ).append("\n"); 
		query.append("AND BK.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_TP_ID = '301'" ).append("\n"); 
		query.append("AND MSG.EDI_MSG_IND_CD = '5'" ).append("\n"); 
		query.append("AND MSG.MSG_TP_DESC = '1'" ).append("\n"); 
		query.append("AND MFT.YARD_TYPE = 'M'" ).append("\n"); 
		query.append("AND ROWNUM =1)    EDI_ID" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append(",MDM_LOCATION LOC" ).append("\n"); 
		query.append(",BKG_VVD VVD" ).append("\n"); 
		query.append(",BKG_CUSTOMER CUST" ).append("\n"); 
		query.append(",MDM_COMMODITY COM" ).append("\n"); 
		query.append(",(SELECT 1 AS ORD ,'M' AS YARD_TYPE FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 2 ,'F' FROM DUAL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 3 ,'T' FROM DUAL) MFT" ).append("\n"); 
		query.append("WHERE BKG.POR_CD = LOC.LOC_CD (+)" ).append("\n"); 
		query.append("AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("AND BKG.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND BKG.BKG_NO = CUST.BKG_NO (+)" ).append("\n"); 
		query.append("AND CUST.BKG_CUST_TP_CD (+)  = 'S'" ).append("\n"); 
		query.append("AND BKG.CMDT_CD = COM.CMDT_CD (+)" ).append("\n"); 
		query.append("AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("#if (${from_dt} != '')" ).append("\n"); 
		query.append("#if (${datetype} == 'BKG')" ).append("\n"); 
		query.append("AND BKG.BKG_CRE_DT  BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("#elseif(${datetype} == 'PUP')" ).append("\n"); 
		query.append("AND BKG.MTY_PKUP_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd}!='')" ).append("\n"); 
		query.append("AND BKG.BKG_OFC_CD = UPPER(@[bkg_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${doc_usr_id}!='')" ).append("\n"); 
		query.append("AND BKG.DOC_USR_ID  = UPPER(@[doc_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_ctrl_ofc_cd}!='')" ).append("\n"); 
		query.append("AND BKG.EQ_CTRL_OFC_CD = UPPER(@[eq_ctrl_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} !='')" ).append("\n"); 
		query.append("AND VVD.VSL_CD = UPPER(substr(@[vvd],0,4))" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = UPPER(substr(@[vvd],5,4))" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = UPPER(substr(@[vvd],9,1))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} !='')" ).append("\n"); 
		query.append("AND BKG.POR_CD   = UPPER(@[por_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} !='')" ).append("\n"); 
		query.append("AND BKG.POL_CD   = UPPER(@[pol_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!='')" ).append("\n"); 
		query.append("AND BKG.POD_CD   = UPPER(@[pod_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mty_pkup_yd_cd}!='')" ).append("\n"); 
		query.append("AND BKG.MTY_PKUP_YD_CD = UPPER(@[mty_pkup_yd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${full_rtn_yd_cd}!='')" ).append("\n"); 
		query.append("AND BKG.FULL_RTN_YD_CD = UPPER(@[full_rtn_yd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no}!='')" ).append("\n"); 
		query.append("AND BKG.BKG_NO  = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pi_type}!='')" ).append("\n"); 
		query.append("AND DECODE(BKG.POR_CD,BKG.POL_CD,'P','I') = UPPER(@[pi_type])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt2}!='')" ).append("\n"); 
		query.append("AND BKG.LODG_DUE_DT BETWEEN TO_DATE(@[from_dt2],'yyyy-mm-dd hh24:mi') AND TO_DATE(@[end_dt2],'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${empty_full_chk} == 'Y')" ).append("\n"); 
		query.append("AND BKG.MTY_PKUP_YD_CD != BKG.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_confirm}=='Y')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BKG.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_confirm}=='N')" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BKG.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_NO" ).append("\n"); 
		query.append(",COL_CHK" ).append("\n"); 
		query.append(") A2" ).append("\n"); 
		query.append(",(SELECT BKG_NO" ).append("\n"); 
		query.append(",NTC_KND_CD" ).append("\n"); 
		query.append(",MIN(DECODE(RK, 1, DECODE(NTC_VIA_CD, 'F', NTC_FAX_NO, ''))) AS NTC_FAX_NO" ).append("\n"); 
		query.append(",MIN(DECODE(RK, 1, DECODE(NTC_VIA_CD, 'F', BKG_NTC_SND_RSLT_CD, ''))) AS FAX_SND_RSLT_CD" ).append("\n"); 
		query.append(",MIN(DECODE(RK, 1, DECODE(NTC_VIA_CD, 'F', SND_DT, ''))) AS FAX_SND_DT" ).append("\n"); 
		query.append(",MIN(DECODE(RK, 1, DECODE(NTC_VIA_CD, 'M', NTC_EML, ''))) AS NTC_EML" ).append("\n"); 
		query.append(",MIN(DECODE(RK, 1, DECODE(NTC_VIA_CD, 'M', BKG_NTC_SND_RSLT_CD, ''))) AS EML_SND_RSLT_CD" ).append("\n"); 
		query.append(",MIN(DECODE(RK, 1, DECODE(NTC_VIA_CD, 'M', SND_DT, ''))) AS EML_SND_DT" ).append("\n"); 
		query.append(",MIN(DECODE(RK, 1, DECODE(NTC_VIA_CD, 'E', SND_DT, ''))) AS EDI_SND_DT" ).append("\n"); 
		query.append(",MIN(DECODE(RK, 1, DIFF_RMK)) AS DIFF_RMK" ).append("\n"); 
		query.append("FROM (SELECT NTC.BKG_NO" ).append("\n"); 
		query.append(",NTC.NTC_VIA_CD" ).append("\n"); 
		query.append(",DECODE(NTC.NTC_KND_CD, 'FC', DECODE(BKG.FULL_RTN_YD_CD, BKG.POL_NOD_CD, 'F/T', 'F')" ).append("\n"); 
		query.append(", 'BT', DECODE(BKG.FULL_RTN_YD_CD, BKG.POL_NOD_CD, 'F/T', 'T')" ).append("\n"); 
		query.append(", 'CN', 'M') AS NTC_KND_CD" ).append("\n"); 
		query.append(",NTC.NTC_FAX_NO" ).append("\n"); 
		query.append(",NTC.NTC_EML" ).append("\n"); 
		query.append(",NTC.BKG_NTC_SND_RSLT_CD" ).append("\n"); 
		query.append(",TO_CHAR(NTC.SND_DT, 'YYYY-MM-DD HH24:MI') AS SND_DT" ).append("\n"); 
		query.append(",NTC.DIFF_RMK" ).append("\n"); 
		query.append(",RANK() OVER(PARTITION BY NTC.BKG_NO,NTC.NTC_KND_CD,NTC.NTC_VIA_CD ORDER BY NTC.HIS_SEQ DESC) AS RK" ).append("\n"); 
		query.append(",NTC.HIS_SEQ" ).append("\n"); 
		query.append("FROM BKG_NTC_HIS NTC" ).append("\n"); 
		query.append(",BKG_BOOKING BKG" ).append("\n"); 
		query.append("#if (${vvd} !='')" ).append("\n"); 
		query.append(",BKG_VVD VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE NTC.NTC_KND_CD IN ('CN', 'BT', 'FC')" ).append("\n"); 
		query.append("AND BKG.BKG_NO = NTC.BKG_NO" ).append("\n"); 
		query.append("#if (${vvd} !='')" ).append("\n"); 
		query.append("AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt} != '')" ).append("\n"); 
		query.append("#if (${datetype} == 'BKG')" ).append("\n"); 
		query.append("AND BKG.BKG_CRE_DT  BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("#elseif(${datetype} == 'PUP')" ).append("\n"); 
		query.append("AND BKG.MTY_PKUP_DT BETWEEN to_date(@[from_dt] ,'yyyy-mm-dd hh24:mi') AND to_date(@[end_dt] ,'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_ofc_cd}!='')" ).append("\n"); 
		query.append("AND BKG.BKG_OFC_CD = UPPER(@[bkg_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${doc_usr_id}!='')" ).append("\n"); 
		query.append("AND BKG.DOC_USR_ID  = UPPER(@[doc_usr_id])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_ctrl_ofc_cd}!='')" ).append("\n"); 
		query.append("AND BKG.EQ_CTRL_OFC_CD = UPPER(@[eq_ctrl_ofc_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd} !='')" ).append("\n"); 
		query.append("AND VVD.VSL_CD = UPPER(substr(@[vvd],0,4))" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = UPPER(substr(@[vvd],5,4))" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = UPPER(substr(@[vvd],9,1))" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} !='')" ).append("\n"); 
		query.append("AND BKG.POR_CD   = UPPER(@[por_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} !='')" ).append("\n"); 
		query.append("AND BKG.POL_CD   = UPPER(@[pol_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd}!='')" ).append("\n"); 
		query.append("AND BKG.POD_CD   = UPPER(@[pod_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mty_pkup_yd_cd}!='')" ).append("\n"); 
		query.append("AND BKG.MTY_PKUP_YD_CD = UPPER(@[mty_pkup_yd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${full_rtn_yd_cd}!='')" ).append("\n"); 
		query.append("AND BKG.FULL_RTN_YD_CD = UPPER(@[full_rtn_yd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no}!='')" ).append("\n"); 
		query.append("AND BKG.BKG_NO  = UPPER(@[bkg_no])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pi_type}!='')" ).append("\n"); 
		query.append("AND DECODE(BKG.POR_CD,BKG.POL_CD,'P','I') = UPPER(@[pi_type])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${from_dt2}!='')" ).append("\n"); 
		query.append("AND BKG.LODG_DUE_DT BETWEEN TO_DATE(@[from_dt2],'yyyy-mm-dd hh24:mi') AND TO_DATE(@[end_dt2],'yyyy-mm-dd hh24:mi')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${empty_full_chk} == 'Y')" ).append("\n"); 
		query.append("AND BKG.MTY_PKUP_YD_CD != BKG.FULL_RTN_YD_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_confirm}=='Y')" ).append("\n"); 
		query.append("AND EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BKG.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${eq_confirm}=='N')" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 1 FROM BKG_DOC_PROC_SKD WHERE BKG_NO = BKG.BKG_NO AND BKG_DOC_PROC_TP_CD = 'CNTCFM' AND DOC_PERF_DELT_FLG = 'N')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RK = 1" ).append("\n"); 
		query.append("GROUP BY BKG_NO" ).append("\n"); 
		query.append(",NTC_KND_CD) A3" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL A4" ).append("\n"); 
		query.append(",COM_INTG_CD_DTL A5" ).append("\n"); 
		query.append("WHERE A1.YD_CD(+) = A2.YARD" ).append("\n"); 
		query.append("AND A2.BKG_NO = A3.BKG_NO (+)" ).append("\n"); 
		query.append("AND A2.YARD_TYPE = A3.NTC_KND_CD (+)" ).append("\n"); 
		query.append("AND A3.FAX_SND_RSLT_CD = A4.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("AND A4.INTG_CD_ID (+)  = 'CD00959'" ).append("\n"); 
		query.append("AND A3.EML_SND_RSLT_CD = A5.INTG_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("AND A5.INTG_CD_ID (+)  = 'CD02045'" ).append("\n"); 
		query.append("ORDER BY A2.USA_SEQ" ).append("\n"); 
		query.append(",A2.COL_CHK" ).append("\n"); 

	}
}