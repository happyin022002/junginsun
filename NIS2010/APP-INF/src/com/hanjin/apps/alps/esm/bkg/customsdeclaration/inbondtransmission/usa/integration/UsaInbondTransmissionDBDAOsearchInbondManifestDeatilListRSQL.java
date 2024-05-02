/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaInbondTransmissionDBDAOsearchInbondManifestDeatilListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.22
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.10.22 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaInbondTransmissionDBDAOsearchInbondManifestDeatilListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0408 하단 시트 조회용, Paperless MIB Generate 화면의 Inbond/Local 상세조회용.
	  * outVO: UsaInbondManifestDetailListVO
	  * public class UsaInbondManifestDetailListVO extends InbondManifestDetailListVO 수정해야함
	  * </pre>
	  */
	public UsaInbondTransmissionDBDAOsearchInbondManifestDeatilListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("inbond_local",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hub_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaInbondTransmissionDBDAOsearchInbondManifestDeatilListRSQL").append("\n"); 
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
		query.append("SELECT A.BL_NO," ).append("\n"); 
		query.append("    MAX(A.DEL_CD) del_cd," ).append("\n"); 
		query.append("    MAX(A.USA_LST_LOC_CD) usa_lst_loc_cd," ).append("\n"); 
		query.append("    MAX(A.HUB_LOC_CD) hub_loc_cd," ).append("\n"); 
		query.append("    MAX(IBD.IBD_TRSP_NO) ibd_trsp_no," ).append("\n"); 
		query.append("    MAX(IBD.IBD_TRSP_TP_CD) ibd_trsp_tp_cd," ).append("\n"); 
		query.append("    MAX(TO_CHAR(A.PCK_QTY)) pck_qty," ).append("\n"); 
		query.append("    MAX(IBD.CSTMS_CLR_TP_CD) cstms_clr_tp_cd," ).append("\n"); 
		query.append("    --MAX(DECODE(A.IT_STAGE,NULL,'A','D'))," ).append("\n"); 
		query.append("    MAX(IBD.LOCL_CLR_IPI_MVMT_FLG) locl_clr_ipi_mvmt_flg," ).append("\n"); 
		query.append("    MAX(NVL(CR.CSTMS_CLR_CD,'  ')) dspo_cd," ).append("\n"); 
		query.append("    MAX(R.RCV_LOC_CD) rcv_loc_cd," ).append("\n"); 
		query.append("    MAX(NVL(A.RCV_TERM_CD,' ')) rcv_term_cd," ).append("\n"); 
		query.append("    MAX(NVL(A.DE_TERM_CD,' '))de_term_cd," ).append("\n"); 
		query.append("    MAX(DECODE(BCK.CUST_TO_ORD_FLG,'Y',BCN.CUST_CNT_CD || BCN.CUST_SEQ, BCC.CUST_CNT_CD || BCC.CUST_SEQ)) cust_seq," ).append("\n"); 
		query.append("    REPLACE(DECODE(BCK.CUST_TO_ORD_FLG,'Y',BCN.CUST_NM, BCC.CUST_NM),CHR(13)||CHR(10),' ') cust_nm," ).append("\n"); 
		query.append("    MAX(A.CSTMS_LOC_CD) cstms_loc_cd," ).append("\n"); 
		query.append("	'' LCL_FLG, @[vvd] vvd, @[pod_cd] pod_cd, MAX(A.CSTMS_POL_CD) pol_cd," ).append("\n"); 
		query.append("	 MAX(A.USA_LST_LOC_CD) old_usa, MAX(IBD.CSTMS_CLR_TP_CD) old_entry, MAX(IBD.IBD_TRSP_TP_CD) old_tp," ).append("\n"); 
		query.append("	MAX(A.HUB_LOC_CD) old_hub," ).append("\n"); 
		query.append("	'' CSTMS_CLR_TP_CD_CHG, 	-- VO FILED" ).append("\n"); 
		query.append("	'' LOCL_CLR_IPI_MVMT_FLG, 	-- VO FILED" ).append("\n"); 
		query.append("    '' IBD_TRSP_TP_CD_CHG 		-- VO FILED" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_BL A , BKG_CSTMS_ADV_IBD IBD " ).append("\n"); 
		query.append("    ,BKG_CSTMS_ADV_RSLT R , BKG_CUSTOMER BCC, BKG_BOOKING BCK, BKG_CUSTOMER BCN " ).append("\n"); 
		query.append("    ,BKG_CGO_RLSE CR--, MDM_LOCATION PL, MDM_LOCATION DL" ).append("\n"); 
		query.append("WHERE A.CNT_CD = 'US'" ).append("\n"); 
		query.append("     AND A.CNT_CD = IBD.CNT_CD(+)" ).append("\n"); 
		query.append("     AND A.BL_NO = IBD.BL_NO(+)" ).append("\n"); 
		query.append("     AND A.CNT_CD = R.CNT_CD(+)  " ).append("\n"); 
		query.append("     AND A.BL_NO  = R.BL_NO(+)" ).append("\n"); 
		query.append("     AND R.DSPO_CD(+) = '1C'" ).append("\n"); 
		query.append("     AND A.VSL_CD = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("     AND A.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("     AND A.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("     AND A.CSTMS_POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("     AND NVL(A.HUB_LOC_CD,'C') = NVL(@[hub_loc_cd],'C')" ).append("\n"); 
		query.append("     AND A.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("	 AND A.CSTMS_LOC_CD = @[cstms_loc_cd]" ).append("\n"); 
		query.append("#if (${inbond_local} != '') " ).append("\n"); 
		query.append("	AND IBD.CSTMS_CLR_TP_CD = @[inbond_local]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND A.MF_STS_CD = 'A'" ).append("\n"); 
		query.append("     AND  A.BKG_NO =  BCC.BKG_NO AND BCC.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("     AND A.BKG_NO =  BCK.BKG_NO" ).append("\n"); 
		query.append("     AND A.BKG_NO =  BCN.BKG_NO AND BCN.BKG_CUST_TP_CD = 'N'" ).append("\n"); 
		query.append("     AND A.BL_NO = CR.BL_NO(+)" ).append("\n"); 
		query.append("     AND (CR.CSTMS_CLR_CD is null OR CR.CSTMS_CLR_CD <> 'Y')" ).append("\n"); 
		query.append("	-- 2009/11/13 정민정 과장 로컬만 조회 요청." ).append("\n"); 
		query.append("	-- 하동일 수석, pod의 SCC와 del의 SCC가 같으면 로컬임." ).append("\n"); 
		query.append("	-- 의미상, CSTMS_CLR_TP_CD의 I/L의 로컬과는 틀림." ).append("\n"); 
		query.append("	--AND A.POD_CD = PL.LOC_CD" ).append("\n"); 
		query.append("	--AND A.DEL_CD = DL.LOC_CD" ).append("\n"); 
		query.append("	--AND PL.SCC_CD = DL.SCC_CD" ).append("\n"); 
		query.append("	AND A.MF_NO IS NULL" ).append("\n"); 
		query.append("GROUP BY A.BL_NO, BCK.CUST_TO_ORD_FLG, BCC.CUST_NM, BCN.CUST_NM" ).append("\n"); 

	}
}