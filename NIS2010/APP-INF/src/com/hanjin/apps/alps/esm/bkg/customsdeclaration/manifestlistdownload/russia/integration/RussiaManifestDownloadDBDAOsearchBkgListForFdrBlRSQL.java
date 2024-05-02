/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RussiaManifestDownloadDBDAOsearchBkgListForFdrBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.22
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2013.08.22 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaManifestDownloadDBDAOsearchBkgListForFdrBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgListForFdrBl
	  * </pre>
	  */
	public RussiaManifestDownloadDBDAOsearchBkgListForFdrBlRSQL(){
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
		params.put("ob_sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_cust_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ob_srep_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cust_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.integration").append("\n"); 
		query.append("FileName : RussiaManifestDownloadDBDAOsearchBkgListForFdrBlRSQL").append("\n"); 
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
		query.append("#if ((''==${vsl_cd} || ''==${skd_voy_no} || ''==${skd_dir_cd}) && (${bkg_no} == '' && ${bl_no} == '') && ('' !=${bl_obrd_dt_from} && '' !=${bl_obrd_dt_to}))" ).append("\n"); 
		query.append("       /*+ INDEX(DOC XAK2BKG_BL_DOC) */" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       BKG.BKG_NO," ).append("\n"); 
		query.append("       BKG.BKG_STS_CD," ).append("\n"); 
		query.append("       BKG.BL_NO || BKG.BL_TP_CD AS BL_NO," ).append("\n"); 
		query.append("       CST.CUST_CNT_CD || LPAD (CST.CUST_SEQ, 6, 0) AS SHPR_CD," ).append("\n"); 
		query.append("       NVL(RUS.CUST_NM, CST.CUST_NM) AS SHPR_NM," ).append("\n"); 
		query.append("       NVL(RUS.CUST_ADDR, CST.CUST_ADDR) AS SHPR_ADDR," ).append("\n"); 
		query.append("       CNE.CUST_CNT_CD || LPAD (CNE.CUST_SEQ, 6, 0) AS CNEE_CD," ).append("\n"); 
		query.append("       NVL(RUC.CUST_NM, CNE.CUST_NM) AS CNEE_NM," ).append("\n"); 
		query.append("       NVL(RUC.CUST_ADDR, CNE.CUST_ADDR) AS CNEE_ADDR," ).append("\n"); 
		query.append("       NFT.CUST_CNT_CD || LPAD (NFT.CUST_SEQ, 6, 0) AS NTFY_CD," ).append("\n"); 
		query.append("       NVL(RUN.CUST_NM, NFT.CUST_NM) AS NTFY_NM," ).append("\n"); 
		query.append("       NVL(RUN.CUST_ADDR, NFT.CUST_ADDR) AS NTFY_ADDR," ).append("\n"); 
		query.append("       NVL(RUE.CUST_NM, EXC.CUST_NM) AS EX_CUST_NM," ).append("\n"); 
		query.append("       BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS VVD," ).append("\n"); 
		query.append("       BKG.POL_CD," ).append("\n"); 
		query.append("       BKG.POD_CD," ).append("\n"); 
		query.append("       BKG.POR_CD," ).append("\n"); 
		query.append("       BKG.DEL_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BKG" ).append("\n"); 
		query.append("       #if (''!=${vsl_cd} || ''!=${skd_voy_no} || ''!=${skd_dir_cd})" ).append("\n"); 
		query.append("       ,BKG_VVD VVD" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER CST" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER CNE" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER NFT" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER EXC" ).append("\n"); 
		query.append("       ,BKG_BL_ISS ISS" ).append("\n"); 
		query.append("       ,BKG_BL_DOC DOC" ).append("\n"); 
		query.append("       ,BKG_CSTMS_RU_CUST RUS" ).append("\n"); 
		query.append("       ,BKG_CSTMS_RU_CUST RUC" ).append("\n"); 
		query.append("       ,BKG_CSTMS_RU_CUST RUN" ).append("\n"); 
		query.append("       ,BKG_CSTMS_RU_CUST RUE" ).append("\n"); 
		query.append("       #if ('All'!=${bkg_cust_tp_cd} || ''!=${cust_cnt_cd} || ''!=${cust_seq} || ''!=${cust_nm})" ).append("\n"); 
		query.append("       ,BKG_CUSTOMER CST2" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKG.BKG_NO = CST.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'S' = CST.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = CNE.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'C' = CNE.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = NFT.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'N' = NFT.BKG_CUST_TP_CD(+) " ).append("\n"); 
		query.append("   AND BKG.BKG_NO = EXC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND 'E' = EXC.BKG_CUST_TP_CD(+) " ).append("\n"); 
		query.append("   AND BKG.BL_NO = RUS.BL_NO(+)" ).append("\n"); 
		query.append("   AND 'S' = RUS.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BL_NO = RUC.BL_NO(+)" ).append("\n"); 
		query.append("   AND 'C' = RUC.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BL_NO = RUN.BL_NO(+)" ).append("\n"); 
		query.append("   AND 'N' = RUN.BKG_CUST_TP_CD(+)  " ).append("\n"); 
		query.append("   AND BKG.BL_NO = RUE.BL_NO(+)" ).append("\n"); 
		query.append("   AND 'E' = RUE.BKG_CUST_TP_CD(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = DOC.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BKG.BKG_STS_CD NOT IN ('A', 'X')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ('F'==${tp_cd})" ).append("\n"); 
		query.append("       AND BKG.BKG_CGO_TP_CD = 'F'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (''!=${vsl_cd} || ''!=${skd_voy_no} || ''!=${skd_dir_cd})" ).append("\n"); 
		query.append("   AND BKG.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   #if (''!=${vsl_cd})" ).append("\n"); 
		query.append("   AND @[vsl_cd] = VVD.VSL_CD  /*VVD*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${skd_voy_no})" ).append("\n"); 
		query.append("   AND @[skd_voy_no] = VVD.SKD_VOY_NO  /*VVD*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${skd_dir_cd})" ).append("\n"); 
		query.append("   AND @[skd_dir_cd] = VVD.SKD_DIR_CD  /*VVD*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ('All'!=${bkg_cust_tp_cd} || ''!=${cust_cnt_cd} || ''!=${cust_seq} || ''!=${cust_nm})" ).append("\n"); 
		query.append("   AND CST2.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("   #if ('All'!=${bkg_cust_tp_cd})" ).append("\n"); 
		query.append("   AND @[bkg_cust_tp_cd] = CST2.BKG_CUST_TP_CD  /*BKG_CUST_TP_CD*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${cust_cnt_cd})" ).append("\n"); 
		query.append("   AND @[cust_cnt_cd] = CST2.CUST_CNT_CD  /*CUST_CNT_CD*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${cust_seq})" ).append("\n"); 
		query.append("   AND CST2.CUST_SEQ = TO_NUMBER(@[cust_seq])  /*CUST_SEQ*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${cust_nm})" ).append("\n"); 
		query.append("   AND UPPER(CST2.CUST_NM) LIKE UPPER(@[cust_nm])||'%'  /*CUST_NM*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   #if (''!=${pol_cd})" ).append("\n"); 
		query.append("   AND VVD.POL_CD LIKE @[pol_cd]||'%'  /*POL_CD*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${pod_cd})" ).append("\n"); 
		query.append("   AND VVD.POD_CD LIKE @[pod_cd]||'%'  /*POD_CD*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${ob_sls_ofc_cd})" ).append("\n"); 
		query.append("   AND UPPER(BKG.OB_SLS_OFC_CD) LIKE UPPER(@[ob_sls_ofc_cd])||'%'  /*OB_SLS_OFC_CD*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${ob_srep_cd})" ).append("\n"); 
		query.append("   AND UPPER(BKG.OB_SREP_CD) LIKE UPPER(@[ob_srep_cd])||'%'  /*OB_SREP_CD*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${bkg_no})" ).append("\n"); 
		query.append("   AND @[bkg_no] = BKG.BKG_NO  /*BKG_NO*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${bl_no})" ).append("\n"); 
		query.append("   AND @[bl_no] = BKG.BL_NO  /*BL_NO*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   #if (''!=${bl_obrd_dt_from} && ''!=${bl_obrd_dt_to})" ).append("\n"); 
		query.append("   AND DOC.BL_OBRD_DT BETWEEN TO_DATE(@[bl_obrd_dt_from],'RRRRMMDD') AND TO_DATE(@[bl_obrd_dt_to],'RRRRMMDD')  /*BL_OBRD_DT*/" ).append("\n"); 
		query.append("   #elseif (''!=${obl_iss_dt_from} && ''!=${obl_iss_dt_to})" ).append("\n"); 
		query.append("   AND ISS.OBL_ISS_DT BETWEEN TO_DATE(@[obl_iss_dt_from],'RRRRMMDD') AND TO_DATE(@[obl_iss_dt_to],'RRRRMMDD')  /*OBL_ISS_DT*/" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY BKG.BKG_NO" ).append("\n"); 

	}
}