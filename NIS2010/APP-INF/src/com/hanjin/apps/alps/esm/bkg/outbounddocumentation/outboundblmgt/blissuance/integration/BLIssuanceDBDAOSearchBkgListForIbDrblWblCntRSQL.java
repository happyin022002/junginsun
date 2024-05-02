/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBkgListForIbDrblWblCntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.21
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2013.11.21 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBkgListForIbDrblWblCntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgListForIbDrblWblCnt
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBkgListForIbDrblWblCntRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_dt_from",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eta_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_obrd_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eta_dt_from",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_iss_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_chk_opt2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bl_obrd_dt_to",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_chk_opt1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBkgListForIbDrblWblCntRSQL").append("\n"); 
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
		query.append("SELECT COUNT(DISTINCT BKG_NO) AS FAX_BL_TOTAL,                            --FAX(HISTORY제외)" ).append("\n"); 
		query.append("       COUNT(DISTINCT BKG_NO||FAX_HIS_SEQ) AS FAX_TOTAL,                  --FAX(HISTORY포함)" ).append("\n"); 
		query.append("       SUM  (CASE WHEN 3 = FAX_STS_CD THEN 1 ELSE 0 END) AS FAX_SUCCESS,  --SUCCESS(COMPLETED)" ).append("\n"); 
		query.append("       SUM  (CASE WHEN 2 = FAX_STS_CD THEN 1 ELSE 0 END) AS FAX_SENDING,  --SENDING(SENDING)" ).append("\n"); 
		query.append("       SUM  (CASE WHEN 1 = FAX_STS_CD THEN 1 ELSE 0 END) AS FAX_NO_SEND,  --NOSEND" ).append("\n"); 
		query.append("       SUM  (CASE WHEN 4 = FAX_STS_CD THEN 1 ELSE 0 END) AS FAX_FAILED,   --FAILED(FAILED)" ).append("\n"); 
		query.append("       COUNT(DISTINCT BKG_NO) AS EML_BL_TOTAL,                            --EML(HISTORY제외)" ).append("\n"); 
		query.append("       COUNT(DISTINCT BKG_NO||EML_HIS_SEQ) AS EML_TOTAL,                  --EML(HISTORY포함)" ).append("\n"); 
		query.append("       SUM  (CASE WHEN 3 = EML_STS_CD THEN 1 ELSE 0 END) AS EML_SUCCESS,  --SUCCESS(COMPLETED)" ).append("\n"); 
		query.append("       SUM  (CASE WHEN 2 = EML_STS_CD THEN 1 ELSE 0 END) AS EML_SENDING,  --SENDING(SENDING)" ).append("\n"); 
		query.append("       SUM  (CASE WHEN 1 = EML_STS_CD THEN 1 ELSE 0 END) AS EML_NO_SEND,  --NOSEND" ).append("\n"); 
		query.append("       SUM  (CASE WHEN 4 = EML_STS_CD THEN 1 ELSE 0 END) AS EML_FAILED    --FAILED(FAILED)" ).append("\n"); 
		query.append("  FROM (SELECT DISTINCT" ).append("\n"); 
		query.append("               BKG.BKG_NO," ).append("\n"); 
		query.append("               FAX.BKG_NO AS FAX_BKG_NO," ).append("\n"); 
		query.append("               FAX.HIS_SEQ AS FAX_HIS_SEQ," ).append("\n"); 
		query.append("               NVL2(FSI.FAX_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(FSI.FAX_PROC_STS_CD,1,2,2,2,3,2,4,2,5,3,6,4,1)," ).append("\n"); 
		query.append("               NVL2(FAX.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(FAX.BKG_NTC_SND_RSLT_CD,4,2,5,3,6,4,1),1)) AS FAX_STS_CD," ).append("\n"); 
		query.append("               EML.BKG_NO AS EML_BKG_NO," ).append("\n"); 
		query.append("               EML.HIS_SEQ AS EML_HIS_SEQ," ).append("\n"); 
		query.append("               NVL2(ESI.EML_PROC_STS_CD," ).append("\n"); 
		query.append("               DECODE(ESI.EML_PROC_STS_CD,1,2,2,2,3,3,4,4,1)," ).append("\n"); 
		query.append("               NVL2(EML.BKG_NTC_SND_RSLT_CD," ).append("\n"); 
		query.append("               DECODE(EML.BKG_NTC_SND_RSLT_CD,3,3,4,4,1),1)) AS EML_STS_CD" ).append("\n"); 
		query.append("          FROM (SELECT BKG.BKG_NO," ).append("\n"); 
		query.append("                       MAX(BKG.BKG_STS_CD)      AS BKG_STS_CD," ).append("\n"); 
		query.append("                       MAX(BKG.BL_NO)           AS BL_NO," ).append("\n"); 
		query.append("                       MAX(BKG.BL_TP_CD)        AS BL_TP_CD," ).append("\n"); 
		query.append("                       MAX(BKG.VSL_CD)          AS VSL_CD," ).append("\n"); 
		query.append("                       MAX(BKG.SKD_VOY_NO)      AS SKD_VOY_NO," ).append("\n"); 
		query.append("                       MAX(BKG.SKD_DIR_CD)      AS SKD_DIR_CD," ).append("\n"); 
		query.append("                       MAX(BKG.POL_CD)          AS POL_CD," ).append("\n"); 
		query.append("                       MAX(BKG.POD_CD)          AS POD_CD," ).append("\n"); 
		query.append("                       MAX(BKG.CUST_TO_ORD_FLG) AS CUST_TO_ORD_FLG" ).append("\n"); 
		query.append("                  FROM VSK_VSL_PORT_SKD SKD," ).append("\n"); 
		query.append("                       BKG_BOOKING      BKG," ).append("\n"); 
		query.append("                       BKG_VVD          VVD" ).append("\n"); 
		query.append("                 WHERE BKG.VSL_CD = SKD.VSL_CD" ).append("\n"); 
		query.append("                   AND BKG.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                   AND BKG.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                   AND NVL(BKG.PST_RLY_PORT_CD, VVD.POD_CD) = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND BKG.BKG_STS_CD NOT IN ('A', 'X')" ).append("\n"); 
		query.append("                   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("                   AND VVD.VSL_PRE_PST_CD || VVD.VSL_SEQ =" ).append("\n"); 
		query.append("                       (SELECT MAX (VSL_PRE_PST_CD || VSL_SEQ) FROM BKG_VVD WHERE BKG_NO = BKG.BKG_NO)" ).append("\n"); 
		query.append("                   #if (''!=${eta_dt_from} && ''!=${eta_dt_to})" ).append("\n"); 
		query.append("                   AND SKD.VPS_ETA_DT BETWEEN TO_DATE(@[eta_dt_from],'RRRRMMDD') AND TO_DATE(@[eta_dt_to],'RRRRMMDD')  /*ETA_DT*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if ('W'==${bl_tp_cd})" ).append("\n"); 
		query.append("                   AND @[bl_tp_cd] = BKG.BL_TP_CD  /*BL_TP_CD*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (''!=${pod_cd})" ).append("\n"); 
		query.append("                   AND BKG.POD_CD LIKE @[pod_cd]||'%'   /*POD_CD*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (''!=${pol_cd})" ).append("\n"); 
		query.append("                   AND BKG.POL_CD LIKE @[pol_cd]||'%'  /*POL_CD*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (''!=${sc_no})" ).append("\n"); 
		query.append("                   AND @[sc_no] = BKG.SC_NO  /*SC_NO*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (''!=${bl_no})" ).append("\n"); 
		query.append("                   AND @[bl_no] = BKG.BL_NO  /*BL_NO*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (''!=${vsl_cd})" ).append("\n"); 
		query.append("                   AND @[vsl_cd] = VVD.VSL_CD  /*VVD*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (''!=${skd_voy_no})" ).append("\n"); 
		query.append("                   AND @[skd_voy_no] = VVD.SKD_VOY_NO  /*VVD*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if (''!=${skd_dir_cd})" ).append("\n"); 
		query.append("                   AND @[skd_dir_cd] = VVD.SKD_DIR_CD  /*VVD*/" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("				   #if (''!= ${cgo_chk_opt1} || ''!= ${cgo_chk_opt2} )" ).append("\n"); 
		query.append("				   AND BKG.BKG_CGO_TP_CD IN (@[cgo_chk_opt1], @[cgo_chk_opt2])" ).append("\n"); 
		query.append("				   #end" ).append("\n"); 
		query.append("                   GROUP BY BKG.BKG_NO" ).append("\n"); 
		query.append("               ) BKG" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER FFC" ).append("\n"); 
		query.append("               ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("               ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("               #if ('All'!=${bkg_cust_tp_cd} || ''!=${cust_cnt_cd} || ''!=${cust_seq} || ''!=${cust_nm})" ).append("\n"); 
		query.append("               ,BKG_CUSTOMER CST2" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               ,BKG_NTC_HIS FAX" ).append("\n"); 
		query.append("               ,BKG_NTC_HIS EML" ).append("\n"); 
		query.append("               ,COM_FAX_SND_INFO FSI" ).append("\n"); 
		query.append("               ,COM_EML_SND_INFO ESI" ).append("\n"); 
		query.append("               #if ('W'!=${bl_tp_cd})" ).append("\n"); 
		query.append("               ,BKG_NTC_HIS FAX2" ).append("\n"); 
		query.append("               ,BKG_NTC_HIS EML2" ).append("\n"); 
		query.append("               ,COM_FAX_SND_INFO FSI2" ).append("\n"); 
		query.append("               ,COM_EML_SND_INFO ESI2" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("         WHERE BKG.BKG_NO = CST.BKG_NO(+)" ).append("\n"); 
		query.append("           AND DECODE (BKG.CUST_TO_ORD_FLG, 'Y', 'N', 'C') = CST.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = FFC.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'F' = FFC.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("           #if ('All'!=${bkg_cust_tp_cd} || ''!=${cust_cnt_cd} || ''!=${cust_seq} || ''!=${cust_nm})" ).append("\n"); 
		query.append("               AND CST2.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("               #if ('All'!=${bkg_cust_tp_cd})" ).append("\n"); 
		query.append("               AND @[bkg_cust_tp_cd] = CST2.BKG_CUST_TP_CD  /*BKG_CUST_TP_CD*/" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (''!=${cust_cnt_cd})" ).append("\n"); 
		query.append("               AND @[cust_cnt_cd] = CST2.CUST_CNT_CD  /*CUST_CNT_CD*/" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (''!=${cust_seq})" ).append("\n"); 
		query.append("               AND CST2.CUST_SEQ = TO_NUMBER(@[cust_seq])  /*CUST_SEQ*/" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               #if (''!=${cust_nm})" ).append("\n"); 
		query.append("               AND UPPER(CST2.CUST_NM) LIKE UPPER(@[cust_nm])||'%'  /*CUST_NM*/" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = FAX.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'F' = FAX.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = EML.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'M' = EML.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("           AND FAX.SND_ID = FSI.FAX_SND_NO(+)" ).append("\n"); 
		query.append("           AND EML.SND_ID = ESI.EML_SND_NO(+)" ).append("\n"); 
		query.append("           #if ('W'==${bl_tp_cd})" ).append("\n"); 
		query.append("           AND 'WB' = FAX.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(FAX.HIS_SEQ,1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = FAX.BKG_NO" ).append("\n"); 
		query.append("                AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("                AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("           AND 'WB' = EML.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(EML.HIS_SEQ,1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = EML.BKG_NO" ).append("\n"); 
		query.append("                AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("                AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("           #else" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = FAX2.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'F' = FAX2.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("           AND FAX2.SND_ID = FSI2.FAX_SND_NO(+)" ).append("\n"); 
		query.append("           AND BKG.BKG_NO = EML2.BKG_NO(+)" ).append("\n"); 
		query.append("           AND 'M' = EML2.NTC_VIA_CD(+)" ).append("\n"); 
		query.append("           AND EML2.SND_ID = ESI2.EML_SND_NO(+)" ).append("\n"); 
		query.append("           AND 'NN' = FAX.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(FAX.HIS_SEQ,1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = FAX.BKG_NO" ).append("\n"); 
		query.append("                AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("                AND 'NN' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("           AND 'NN' = EML.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(EML.HIS_SEQ,1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = EML.BKG_NO" ).append("\n"); 
		query.append("                AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("                AND 'NN' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("           AND 'WB' = FAX2.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(FAX2.HIS_SEQ,1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = FAX2.BKG_NO" ).append("\n"); 
		query.append("                AND 'F' = NTC_VIA_CD" ).append("\n"); 
		query.append("                AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("           AND 'WB' = EML2.NTC_KND_CD(+)" ).append("\n"); 
		query.append("           AND NVL(EML2.HIS_SEQ,1) =" ).append("\n"); 
		query.append("               NVL((SELECT MAX(HIS_SEQ) FROM BKG_NTC_HIS" ).append("\n"); 
		query.append("                WHERE BKG_NO = EML2.BKG_NO" ).append("\n"); 
		query.append("                AND 'M' = NTC_VIA_CD" ).append("\n"); 
		query.append("                AND 'WB' = NTC_KND_CD),1)" ).append("\n"); 
		query.append("           #end" ).append("\n"); 
		query.append("           #if (''!=${bl_obrd_dt_from} && ''!=${bl_obrd_dt_to})" ).append("\n"); 
		query.append("           AND DOC.BL_OBRD_DT BETWEEN TO_DATE(@[bl_obrd_dt_from],'RRRRMMDD') AND TO_DATE(@[bl_obrd_dt_to],'RRRRMMDD')  /*BL_OBRD_DT*/" ).append("\n"); 
		query.append("           #elseif (''!=${obl_iss_dt_from} && ''!=${obl_iss_dt_to})" ).append("\n"); 
		query.append("           AND ISS.OBL_ISS_DT BETWEEN TO_DATE(@[obl_iss_dt_from],'RRRRMMDD') AND TO_DATE(@[obl_iss_dt_to],'RRRRMMDD')  /*OBL_ISS_DT*/" ).append("\n"); 
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
		query.append("       )" ).append("\n"); 

	}
}