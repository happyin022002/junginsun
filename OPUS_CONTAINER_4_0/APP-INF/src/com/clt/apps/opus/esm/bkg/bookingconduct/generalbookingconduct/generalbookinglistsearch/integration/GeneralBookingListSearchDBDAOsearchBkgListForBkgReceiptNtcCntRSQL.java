/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.04
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.08.04 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgListForBkgReceiptNtcCnt
	  * </pre>
	  */
	public GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_staff",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_kind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eml_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fax_proc_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_rep",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sales_ofc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingListSearchDBDAOsearchBkgListForBkgReceiptNtcCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(DISTINCT BKG_NO) AS FAX_BKG_TOTAL,                                                                    --FAX(HISTORY제외)" ).append("\n"); 
		query.append("       COUNT(DISTINCT BKG_NO||FAX_HIS_SEQ) AS FAX_TOTAL,                                                           --FAX(HISTORY포함)" ).append("\n"); 
		query.append("       COUNT(DISTINCT CASE WHEN FAX_STS_CD=5 THEN BKG_NO||FAX_HIS_SEQ ELSE NULL END) AS FAX_SUCCESS,               --SUCCESS(COMPLETED)" ).append("\n"); 
		query.append("       COUNT(DISTINCT CASE WHEN FAX_STS_CD IN (1,2,3,4,9) THEN BKG_NO||FAX_HIS_SEQ ELSE NULL END) AS FAX_SENDING,  --SENDING(SENDING)" ).append("\n"); 
		query.append("       COUNT(DISTINCT CASE WHEN FAX_STS_CD IS NULL THEN BKG_NO||FAX_HIS_SEQ ELSE NULL END) AS FAX_NO_SEND,         --NOSEND" ).append("\n"); 
		query.append("       COUNT(DISTINCT CASE WHEN FAX_STS_CD=6 THEN BKG_NO||FAX_HIS_SEQ ELSE NULL END) AS FAX_FAILED,                --FAILED(FAILED)" ).append("\n"); 
		query.append("       COUNT(DISTINCT BKG_NO) AS EML_BKG_TOTAL,                                                                    --EML(HISTORY제외)" ).append("\n"); 
		query.append("       COUNT(DISTINCT BKG_NO||EML_HIS_SEQ) AS EML_TOTAL,                                                           --EML(HISTORY포함)" ).append("\n"); 
		query.append("       COUNT(DISTINCT CASE WHEN EML_STS_CD=3 THEN BKG_NO||EML_HIS_SEQ ELSE NULL END) AS EML_SUCCESS,               --SUCCESS(COMPLETED)" ).append("\n"); 
		query.append("       COUNT(DISTINCT CASE WHEN EML_STS_CD IN (1,2,9) THEN BKG_NO||EML_HIS_SEQ ELSE NULL END) AS EML_SENDING,      --SENDING(SENDING)" ).append("\n"); 
		query.append("       COUNT(DISTINCT CASE WHEN EML_STS_CD IS NULL THEN BKG_NO||EML_HIS_SEQ ELSE NULL END) AS EML_NO_SEND,         --NOSEND" ).append("\n"); 
		query.append("       COUNT(DISTINCT CASE WHEN EML_STS_CD=4 THEN BKG_NO||EML_HIS_SEQ ELSE NULL END) AS EML_FAILED                 --FAILED(FAILED)" ).append("\n"); 
		query.append("  FROM (SELECT DISTINCT" ).append("\n"); 
		query.append("               BKG.BKG_NO," ).append("\n"); 
		query.append("               FAX.BKG_NO AS FAX_BKG_NO," ).append("\n"); 
		query.append("               FAX.HIS_SEQ AS FAX_HIS_SEQ," ).append("\n"); 
		query.append("               NVL2(FAX.SND_ID,NVL(FSI.FAX_PROC_STS_CD,9),NULL) AS FAX_STS_CD," ).append("\n"); 
		query.append("               EML.BKG_NO AS EML_BKG_NO," ).append("\n"); 
		query.append("               EML.HIS_SEQ AS EML_HIS_SEQ," ).append("\n"); 
		query.append("               NVL2(EML.SND_ID,NVL(ESI.EML_PROC_STS_CD,9),NULL) AS EML_STS_CD" ).append("\n"); 
		query.append("          FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("               BKG_VVD VVD," ).append("\n"); 
		query.append("               BKG_CUSTOMER CST," ).append("\n"); 
		query.append("               BKG_CUSTOMER FFC," ).append("\n"); 
		query.append("               BKG_CNTC_PSON CTT," ).append("\n"); 
		query.append("               BKG_BL_ISS ISS," ).append("\n"); 
		query.append("               BKG_BL_DOC DOC," ).append("\n"); 
		query.append("               BKG_CUSTOMER CST2," ).append("\n"); 
		query.append("               BKG_NTC_HIS FAX," ).append("\n"); 
		query.append("               BKG_NTC_HIS EML," ).append("\n"); 
		query.append("               COM_FAX_SND_INFO FSI," ).append("\n"); 
		query.append("               COM_EML_SND_INFO ESI" ).append("\n"); 
		query.append("         WHERE BKG.BKG_NO = CST.BKG_NO" ).append("\n"); 
		query.append("           AND 'S' = CST.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = FFC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'F' = FFC.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = CTT.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'BK' = CTT.BKG_CNTC_PSON_TP_CD(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'X' != BKG.BKG_STS_CD" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("           AND VVD.VSL_PRE_PST_CD IN ('S','T')" ).append("\n"); 
		query.append("           AND CST2.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = FAX.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'F' = FAX.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("           AND 'BK' = FAX.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = EML.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'M' = EML.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("           AND 'BK' = EML.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND FAX.SND_ID = FSI.FAX_SND_NO(+)" ).append("\n"); 
		query.append("           AND EML.SND_ID = ESI.EML_SND_NO(+)" ).append("\n"); 
		query.append("		   AND BKG.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("           #if (''!=${bkg_no})" ).append("\n"); 
		query.append("           AND @[bkg_no] = BKG.BKG_NO" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("		   #if (${multiBkgNo} != '')" ).append("\n"); 
		query.append("           AND BKG.BKG_NO IN (" ).append("\n"); 
		query.append("       		#foreach($multiBkgNoVal IN ${multiBkgNo})        " ).append("\n"); 
		query.append("          		#if($velocityCount < $multiBkgNo.size()) '$multiBkgNoVal', #else '$multiBkgNoVal' #end" ).append("\n"); 
		query.append("       		#end" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bkg_from_dt})" ).append("\n"); 
		query.append("           AND BKG.BKG_CRE_DT > TO_DATE(@[bkg_from_dt],'yyyy-mm-dd')" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bkg_to_dt})" ).append("\n"); 
		query.append("           AND BKG.BKG_CRE_DT < TO_DATE(@[bkg_to_dt],'yyyy-mm-dd') + 1" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bkg_ofc_cd})" ).append("\n"); 
		query.append("           AND @[bkg_ofc_cd] = BKG.BKG_OFC_CD" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bkg_staff})" ).append("\n"); 
		query.append("           AND UPPER(@[bkg_staff]) = UPPER(BKG.DOC_USR_ID)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ('All'!=${bkg_status} && ''!=${bkg_status})" ).append("\n"); 
		query.append("           AND @[bkg_status] = BKG.BKG_STS_CD" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ('All'!=${bkg_kind} && ''!=${bkg_kind})" ).append("\n"); 
		query.append("           AND @[bkg_kind] = BKG.XTER_BKG_RQST_CD" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${vvd})" ).append("\n"); 
		query.append("           AND VVD.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${por_cd})" ).append("\n"); 
		query.append("           AND @[por_cd] = BKG.POR_CD" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${pol_cd})" ).append("\n"); 
		query.append("           AND BKG.POL_CD like @[pol_cd]||'%'" ).append("\n"); 
		query.append("               #if (''!=${pol_yd_cd})" ).append("\n"); 
		query.append("               AND BKG.POL_NOD_CD = @[pol_cd]||@[pol_yd_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${pod_cd})" ).append("\n"); 
		query.append("           AND BKG.POD_CD like @[pod_cd]||'%'" ).append("\n"); 
		query.append("               #if (''!=${pod_yd_cd})" ).append("\n"); 
		query.append("               AND BKG.POD_NOD_CD = @[pod_cd]||@[pod_yd_cd]" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${del_cd})" ).append("\n"); 
		query.append("           AND @[del_cd] = BKG.DEL_CD" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${sales_ofc})" ).append("\n"); 
		query.append("           AND @[sales_ofc] = BKG.OB_SLS_OFC_CD" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${sales_rep})" ).append("\n"); 
		query.append("           AND @[sales_rep] = BKG.OB_SREP_CD" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ('All'!=${cust_tp_cd} && ''!=${cust_tp_cd})" ).append("\n"); 
		query.append("           AND @[cust_tp_cd] = CST2.BKG_CUST_TP_CD" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${cust_cnt_cd})" ).append("\n"); 
		query.append("           AND CST2.CUST_CNT_CD = SUBSTR(@[cust_cnt_cd], 1, 2)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${cust_seq})" ).append("\n"); 
		query.append("           AND CST2.CUST_SEQ = TO_NUMBER(@[cust_seq])" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${cust_nm})" ).append("\n"); 
		query.append("           AND CST2.CUST_NM LIKE @[cust_nm]||'%'" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ('All'!=${fax_proc_sts_cd})" ).append("\n"); 
		query.append("           AND NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(FSI.FAX_PROC_STS_CD,1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("               NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) = @[fax_proc_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if ('All'!=${eml_proc_sts_cd})" ).append("\n"); 
		query.append("           AND NVL2(ESI.EML_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(ESI.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("               NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) = @[eml_proc_sts_cd]" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("		   #if ('Y'!=${edi_hld_flg})" ).append("\n"); 
		query.append("   		   AND BKG.EDI_HLD_FLG = 'N'" ).append("\n"); 
		query.append("   		   #end" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}