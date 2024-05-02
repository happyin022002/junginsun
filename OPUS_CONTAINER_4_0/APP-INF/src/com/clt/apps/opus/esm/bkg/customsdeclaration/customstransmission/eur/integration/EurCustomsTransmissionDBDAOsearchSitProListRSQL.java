/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchSitProListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.10
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.10.10 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchSitProListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * sitpro화면의 조회 쿼리임.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchSitProListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("p_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("p_pol_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_search_pofe_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchSitProListRSQL").append("\n"); 
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
		query.append("#if ('SP'==${p_option})" ).append("\n"); 
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append("       , BK.BKG_STS_CD" ).append("\n"); 
		query.append("       , DECODE(BK.BKG_CGO_TP_CD,'F','Full','R','Full','P','Empty') BKG_CGO_TP_CD" ).append("\n"); 
		query.append("       , BK.BL_NO" ).append("\n"); 
		query.append("       , BK.VSL_CD || BK.SKD_VOY_NO || BK.SKD_DIR_CD TVVD_CD" ).append("\n"); 
		query.append("       , BK.POR_CD" ).append("\n"); 
		query.append("       , BK.POL_NOD_CD B_POL_CD" ).append("\n"); 
		query.append("       , BK.POD_NOD_CD B_POD_CD " ).append("\n"); 
		query.append("       , BK.DEL_CD" ).append("\n"); 
		query.append("       , BK.DOC_USR_ID " ).append("\n"); 
		query.append("       , BV.SLAN_CD" ).append("\n"); 
		query.append("#if (${vvd_cd} == '' && (${bkg_no} != '' || ${bl_no} != ''))" ).append("\n"); 
		query.append("        ,(SELECT COUNT(*) ACT_VVD_CNT" ).append("\n"); 
		query.append("        FROM BKG_VVD" ).append("\n"); 
		query.append("        WHERE BKG_NO IN ( " ).append("\n"); 
		query.append("                SELECT BKG_NO" ).append("\n"); 
		query.append("                  FROM BKG_BOOKING" ).append("\n"); 
		query.append("                 WHERE 1=1" ).append("\n"); 
		query.append("                   #if(${bkg_no} != '')" ).append("\n"); 
		query.append("                   AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   #if(${bl_no} != '')" ).append("\n"); 
		query.append("                   AND BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                   #end" ).append("\n"); 
		query.append("                   )) ACT_VVD_CNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("        , '1' ACT_VVD_CNT    " ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("       , BKG_VVD   BV" ).append("\n"); 
		query.append("       , BKG_RATE  BR" ).append("\n"); 
		query.append("       , BKG_BL_DOC BB" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO    =   BV.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_nO    =   BR.BKG_NO(+)" ).append("\n"); 
		query.append("   AND BK.BKG_NO    =   BB.BKG_NO" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'F')" ).append("\n"); 
		query.append("   AND BK.BKG_CGO_TP_CD in ('F','R')" ).append("\n"); 
		query.append("#elseif (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("   AND BK.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("   AND BK.BL_NO     =   @[bl_no]" ).append("\n"); 
		query.append("   AND (BV.VSL_CD,BV.SKD_VOY_NO,BV.SKD_DIR_CD) = (" ).append("\n"); 
		query.append("                    SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                      FROM BKG_BOOKING" ).append("\n"); 
		query.append("                     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#elseif (${bkg_no} != '') " ).append("\n"); 
		query.append("   AND BK.BKG_NO    =   @[bkg_no]" ).append("\n"); 
		query.append("   AND (BV.VSL_CD,BV.SKD_VOY_NO,BV.SKD_DIR_CD) = (" ).append("\n"); 
		query.append("                    SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                      FROM BKG_BOOKING" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND BV.VSL_CD    =   SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND BV.SKD_VOY_NO=   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND BV.SKD_DIR_CD=   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${pol_cd} != '' && ${pod_cd} == '') " ).append("\n"); 
		query.append("        #if (${ts_search_flag} != 'T')" ).append("\n"); 
		query.append("            AND BV.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("            AND BV.POL_CD    =   BK.POL_CD" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND BV.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif (${pol_cd} == '' && ${pod_cd} != '') " ).append("\n"); 
		query.append("        #if (${ts_search_flag} != 'T')" ).append("\n"); 
		query.append("            AND BV.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("            AND BV.POD_CD    =   BK.POD_CD" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND BV.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif (${pol_cd} != '' && ${pod_cd} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${ts_search_flag} != 'T')" ).append("\n"); 
		query.append("            AND BV.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("            AND BV.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("            AND BV.POL_CD    =   BK.POL_CD" ).append("\n"); 
		query.append("            AND BV.POD_CD    =   BK.POD_CD" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND BV.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("            AND BV.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${por_cd} != '') " ).append("\n"); 
		query.append("       AND BK.POR_CD    =   NVL(@[por_cd], BK.POR_CD)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${del_cd} != '') " ).append("\n"); 
		query.append("       AND BK.DEL_CD    LIKE   @[del_cd] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${pol_yd_cd} != '')" ).append("\n"); 
		query.append("       AND SUBSTR(BV.POL_YD_CD, -2) = @[pol_yd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    #if (${pod_yd_cd} != '')" ).append("\n"); 
		query.append("       AND SUBSTR(BV.POD_YD_CD, -2) = @[pod_yd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append("		#if(${bkg_sts_cd} != 'B')" ).append("\n"); 
		query.append("		AND BK.BKG_STS_CD=   NVL(@[bkg_sts_cd], BK.BKG_STS_CD)" ).append("\n"); 
		query.append("		#else" ).append("\n"); 
		query.append("		AND BB.BDR_FLG = 'Y'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BK.BKG_NO ASC" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("#elseif ('DL'==${p_option})" ).append("\n"); 
		query.append("SELECT DISTINCT BKG.BKG_NO," ).append("\n"); 
		query.append("                BKG.BKG_STS_CD," ).append("\n"); 
		query.append("                DECODE(BKG.BKG_CGO_TP_CD,'F','Full','R','Full','P','Empty') AS BKG_CGO_TP_CD," ).append("\n"); 
		query.append("                BKG.BL_NO," ).append("\n"); 
		query.append("                BKG.VSL_CD || BKG.SKD_VOY_NO || BKG.SKD_DIR_CD AS TVVD_CD," ).append("\n"); 
		query.append("                BKG.POR_CD," ).append("\n"); 
		query.append("                BKG.POL_NOD_CD AS B_POL_CD," ).append("\n"); 
		query.append("                BKG.POD_NOD_CD AS B_POD_CD," ).append("\n"); 
		query.append("                BKG.DEL_CD," ).append("\n"); 
		query.append("                BKG.DOC_USR_ID," ).append("\n"); 
		query.append("                VVD.SLAN_CD," ).append("\n"); 
		query.append("                '1' AS ACT_VVD_CNT" ).append("\n"); 
		query.append("           FROM BKG_BOOKING BKG," ).append("\n"); 
		query.append("                BKG_VVD VVD," ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD SKD1," ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD SKD2," ).append("\n"); 
		query.append("                VSK_VSL_PORT_SKD SKD3," ).append("\n"); 
		query.append("                BKG_BL_DOC BD," ).append("\n"); 
		query.append("                BKG_CONTAINER BC," ).append("\n"); 
		query.append("                BKG_CNTR_MF_DESC BCD," ).append("\n"); 
		query.append("                BKG_CUSTOMER CUST1," ).append("\n"); 
		query.append("                BKG_CUSTOMER CUST2," ).append("\n"); 
		query.append("                BKG_CUSTOMER CUST3," ).append("\n"); 
		query.append("                BKG_DG_CGO DG," ).append("\n"); 
		query.append("       		    BKG_BL_DOC BB" ).append("\n"); 
		query.append("          WHERE 1 = 1" ).append("\n"); 
		query.append("            AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("  		    AND BKG.BKG_NO    =   BB.BKG_NO" ).append("\n"); 
		query.append("            AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND BKG.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("            AND BC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND BCD.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND CUST1.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND CUST1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("            AND CUST2.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND CUST2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("            AND CUST3.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("            AND CUST3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("            AND DG.BKG_NO(+) = BC.BKG_NO" ).append("\n"); 
		query.append("            AND DG.CNTR_NO(+) = BC.CNTR_NO" ).append("\n"); 
		query.append("            AND VVD.VSL_CD = SKD1.VSL_CD" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND VVD.POL_CD = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND SKD1.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("            AND SKD2.VSL_CD = VVD.VSL_CD" ).append("\n"); 
		query.append("            AND SKD2.SKD_VOY_NO = VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND SKD2.SKD_DIR_CD = VVD.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND SKD2.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("            AND VVD.VSL_CD = SKD3.VSL_CD" ).append("\n"); 
		query.append("            AND VVD.SKD_VOY_NO = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("            AND VVD.SKD_DIR_CD = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("            AND VVD.POD_CD = SKD3.VPS_PORT_CD" ).append("\n"); 
		query.append("            AND SKD2.CLPT_SEQ <= SKD3.CLPT_SEQ                                                 -- 1st EU Port 이후에 POD 기항해야함." ).append("\n"); 
		query.append("        #if (${p_pol_cd} != '')" ).append("\n"); 
		query.append("             AND VVD.POL_CD = @[p_pol_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${p_pol_yard_cd} != '')" ).append("\n"); 
		query.append("             AND SUBSTR(VVD.POL_YD_CD, -2) = @[p_pol_yard_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${p_search_pofe_yard_cd} != '')" ).append("\n"); 
		query.append("             AND SKD2.VPS_PORT_CD = SUBSTR(@[p_search_pofe_yard_cd],1,5)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bkg_cgo_tp_cd} == 'F')" ).append("\n"); 
		query.append("             AND BKG.BKG_CGO_TP_CD IN ('F','R')" ).append("\n"); 
		query.append("        #elseif (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("             AND BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${bl_no} != '')" ).append("\n"); 
		query.append("             AND BKG.BL_NO     =   @[bl_no]" ).append("\n"); 
		query.append("             AND (VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD) = (" ).append("\n"); 
		query.append("                              SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                                FROM BKG_BOOKING" ).append("\n"); 
		query.append("                               WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("        #elseif (${bkg_no} != '')" ).append("\n"); 
		query.append("             AND BKG.BKG_NO    =   @[bkg_no]" ).append("\n"); 
		query.append("             AND (VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD) = (" ).append("\n"); 
		query.append("                              SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                                FROM BKG_BOOKING" ).append("\n"); 
		query.append("                               WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                              )" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("             AND VVD.VSL_CD    =   SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("             AND VVD.SKD_VOY_NO=   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("             AND VVD.SKD_DIR_CD=   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${pol_cd} != '' && ${pod_cd} == '')" ).append("\n"); 
		query.append("            #if (${ts_search_flag} != 'T')" ).append("\n"); 
		query.append("             AND VVD.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("             AND VVD.POL_CD    =   BKG.POL_CD" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("             AND VVD.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #elseif (${pol_cd} == '' && ${pod_cd} != '')" ).append("\n"); 
		query.append("            #if (${ts_search_flag} != 'T')" ).append("\n"); 
		query.append("             AND VVD.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("             AND VVD.POD_CD    =   BKG.POD_CD" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("             AND VVD.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #elseif (${pol_cd} != '' && ${pod_cd} != '')" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("            #if (${ts_search_flag} != 'T')" ).append("\n"); 
		query.append("             AND VVD.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("             AND VVD.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("             AND VVD.POL_CD    =   BKG.POL_CD" ).append("\n"); 
		query.append("             AND VVD.POD_CD    =   BKG.POD_CD" ).append("\n"); 
		query.append("            #else" ).append("\n"); 
		query.append("             AND VVD.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("             AND VVD.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("            #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${por_cd} != '')" ).append("\n"); 
		query.append("             AND BKG.POR_CD    =   NVL(@[por_cd], BKG.POR_CD)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${del_cd} != '')" ).append("\n"); 
		query.append("             AND BKG.DEL_CD    LIKE   @[del_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${pol_yd_cd} != '')" ).append("\n"); 
		query.append("             AND SUBSTR(VVD.POL_YD_CD, -2) = @[pol_yd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        #if (${pod_yd_cd} != '')" ).append("\n"); 
		query.append("             AND SUBSTR(VVD.POD_YD_CD, -2) = @[pod_yd_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("		#if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append("			#if(${bkg_sts_cd} != 'B')" ).append("\n"); 
		query.append("			AND BK.BKG_STS_CD=   NVL(@[bkg_sts_cd], BK.BKG_STS_CD)" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("			AND BB.BDR_FLG = 'Y'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("       ORDER BY BKG.BKG_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}