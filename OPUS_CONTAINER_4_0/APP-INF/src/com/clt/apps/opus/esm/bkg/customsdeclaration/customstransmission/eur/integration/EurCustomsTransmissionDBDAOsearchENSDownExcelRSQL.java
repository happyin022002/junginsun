/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchENSDownExcelRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.12
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2016.02.12 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchENSDownExcelRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchENSDownExcel
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchENSDownExcelRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("p_search_pofe_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("p_pol_yard_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchENSDownExcelRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	   ROW_NUMBER() OVER (PARTITION BY BKG_NO ORDER BY CNTR_NO, CNTR_MF_SEQ) SEQ," ).append("\n"); 
		query.append("       NULL AS BKG_NO," ).append("\n"); 
		query.append("       T.BKG_NO AS TRSP_DOC_NO," ).append("\n"); 
		query.append("       T.S_CUST_NM," ).append("\n"); 
		query.append("       T.S_CUST_ADDR," ).append("\n"); 
		query.append("       T.ITEM5," ).append("\n"); 
		query.append("       T.C_CUST_NM," ).append("\n"); 
		query.append("       T.C_CUST_ADDR," ).append("\n"); 
		query.append("       T.ITEM7," ).append("\n"); 
		query.append("       T.N_CUST_NM," ).append("\n"); 
		query.append("       T.N_CUST_ADDR," ).append("\n"); 
		query.append("       '1' AS TRANS_MODE," ).append("\n"); 
		query.append("       T.CRN," ).append("\n"); 
		query.append("       T.CSTMS_PORT_CD," ).append("\n"); 
		query.append("       T.VPS_ETA_DT," ).append("\n"); 
		query.append("       (SELECT RTRIM (XMLAGG (XMLELEMENT (X, SUBSTR (VPS_PORT_CD, 1, 2) || ',') ORDER BY MIN (CLPT_SEQ)).EXTRACT ('//text()').GETSTRINGVAL (), ',')" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("         WHERE B.VSL_CD = SUBSTR (T.CRN, 1, 4)" ).append("\n"); 
		query.append("           AND B.SKD_VOY_NO = SUBSTR (T.CRN, 5, 4)" ).append("\n"); 
		query.append("           AND B.SKD_DIR_CD = SUBSTR (T.CRN, 9, 1)" ).append("\n"); 
		query.append("           AND B.CLPT_SEQ BETWEEN T.POL_SEQ AND T.POD_SEQ" ).append("\n"); 
		query.append("         GROUP BY SUBSTR (VPS_PORT_CD, 1, 2)" ).append("\n"); 
		query.append("       ) AS ROUTE_COUNTRY," ).append("\n"); 
		query.append("       T.ITEM14," ).append("\n"); 
		query.append("       T.LOAD_LOC_CD," ).append("\n"); 
		query.append("       T.UNLOAD_LOC_CD," ).append("\n"); 
		query.append("       T.CSTMS_DESC," ).append("\n"); 
		query.append("       T.PKG_TYPE," ).append("\n"); 
		query.append("       T.PKG_COUNT," ).append("\n"); 
		query.append("       T.CM_SHIP_MARK," ).append("\n"); 
		query.append("       T.CNTR_NO," ).append("\n"); 
		query.append("	   T.CNTR_MF_SEQ," ).append("\n"); 
		query.append("       T.PCK_QTY," ).append("\n"); 
		query.append("       T.CMDT_HS_CD," ).append("\n"); 
		query.append("       T.ACT_WGT," ).append("\n"); 
		query.append("       T.IMDG_UN_NO," ).append("\n"); 
		query.append("       T.SEAL_NBR," ).append("\n"); 
		query.append("       T.ITEM27," ).append("\n"); 
		query.append("       T.DDATE," ).append("\n"); 
		query.append("       T.ITEM29," ).append("\n"); 
		query.append("       T.ITEM30," ).append("\n"); 
		query.append("       T.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("       --EUR.MVMT_REF_NO, EUR.MSG_SND_NO" ).append("\n"); 
		query.append(", (SELECT MVMT_REF_NO" ).append("\n"); 
		query.append("             FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("            WHERE BL_NO = T.BL_NO" ).append("\n"); 
		query.append("              AND   MSG_SND_NO = ( SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                                     FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("                                    WHERE BL_NO = T.BL_NO" ).append("\n"); 
		query.append("                                      AND MVMT_REF_NO IS NOT NULL" ).append("\n"); 
		query.append("                                 )" ).append("\n"); 
		query.append("           ) MVMT_REF_NO" ).append("\n"); 
		query.append("FROM   (SELECT   VVD.BKG_NO," ).append("\n"); 
		query.append("                 CUST1.CUST_NM AS S_CUST_NM," ).append("\n"); 
		query.append("                 CUST1.CUST_ADDR AS S_CUST_ADDR," ).append("\n"); 
		query.append("                 '' AS ITEM5," ).append("\n"); 
		query.append("                 CUST2.CUST_NM AS C_CUST_NM," ).append("\n"); 
		query.append("                 CUST2.CUST_ADDR AS C_CUST_ADDR," ).append("\n"); 
		query.append("                 '' AS ITEM7," ).append("\n"); 
		query.append("                 CUST3.CUST_NM AS N_CUST_NM," ).append("\n"); 
		query.append("                 CUST3.CUST_ADDR AS N_CUST_ADDR," ).append("\n"); 
		query.append("                 VVD.VSL_CD || VVD.SKD_VOY_NO || VVD.SKD_DIR_CD AS CRN," ).append("\n"); 
		query.append("                 VVD.POL_CD AS CSTMS_PORT_CD," ).append("\n"); 
		query.append("                 SKD1.VPS_ETA_DT," ).append("\n"); 
		query.append("                 MIN (DECODE (VVD.POL_CD, SKD1.VPS_PORT_CD, SKD1.CLPT_SEQ)) OVER (PARTITION BY VVD.BKG_NO) AS POL_SEQ," ).append("\n"); 
		query.append("                 MAX (DECODE (VVD.POD_CD, SKD3.VPS_PORT_CD, SKD3.CLPT_SEQ)) OVER (PARTITION BY VVD.BKG_NO) AS POD_SEQ," ).append("\n"); 
		query.append("                 '' AS ITEM14," ).append("\n"); 
		query.append("                 VVD.POL_YD_CD AS LOAD_LOC_CD," ).append("\n"); 
		query.append("                 VVD.POD_YD_CD AS UNLOAD_LOC_CD," ).append("\n"); 
		query.append("                 BD.CSTMS_DESC," ).append("\n"); 
		query.append("                 BCD.PCK_TP_CD AS PKG_TYPE," ).append("\n"); 
		query.append("                 BCD.PCK_QTY AS PKG_COUNT," ).append("\n"); 
		query.append("                 BCD.CNTR_MF_MK_DESC AS CM_SHIP_MARK," ).append("\n"); 
		query.append("                 BC.CNTR_NO," ).append("\n"); 
		query.append("			     BCD.CNTR_MF_SEQ," ).append("\n"); 
		query.append("                 BD.PCK_QTY," ).append("\n"); 
		query.append("                 BCD.CMDT_HS_CD," ).append("\n"); 
		query.append("				 BC.CNTR_WGT AS ACT_WGT," ).append("\n"); 
		query.append("                 DG.IMDG_UN_NO," ).append("\n"); 
		query.append("                 (SELECT RTRIM (XMLAGG (XMLELEMENT (X, CNTR_SEAL_NO || ',') ORDER BY CNTR_SEAL_NO).EXTRACT ('//text()').GETSTRINGVAL(), ',')" ).append("\n"); 
		query.append("                    FROM BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("                   WHERE BKG_NO = BC.BKG_NO AND CNTR_NO = BC.CNTR_NO) AS SEAL_NBR," ).append("\n"); 
		query.append("                 '' AS ITEM27," ).append("\n"); 
		query.append("                 SYSDATE AS DDATE," ).append("\n"); 
		query.append("                 '' AS ITEM29," ).append("\n"); 
		query.append("                 '' AS ITEM30," ).append("\n"); 
		query.append("                 SKD2.CLPT_SEQ AS CLPT_SEQ2," ).append("\n"); 
		query.append("                 SKD3.CLPT_SEQ AS CLPT_SEQ3," ).append("\n"); 
		query.append("				 BCD.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("                ,BKG.BL_NO" ).append("\n"); 
		query.append("        FROM     BKG_BOOKING BKG," ).append("\n"); 
		query.append("                 BKG_VVD VVD," ).append("\n"); 
		query.append("                 VSK_VSL_PORT_SKD SKD1," ).append("\n"); 
		query.append("                 VSK_VSL_PORT_SKD SKD2," ).append("\n"); 
		query.append("                 VSK_VSL_PORT_SKD SKD3," ).append("\n"); 
		query.append("                 BKG_BL_DOC BD," ).append("\n"); 
		query.append("                 BKG_CONTAINER BC," ).append("\n"); 
		query.append("                 BKG_CNTR_MF_DESC BCD," ).append("\n"); 
		query.append("                 BKG_CUSTOMER CUST1," ).append("\n"); 
		query.append("                 BKG_CUSTOMER CUST2," ).append("\n"); 
		query.append("                 BKG_CUSTOMER CUST3," ).append("\n"); 
		query.append("                 BKG_DG_CGO DG" ).append("\n"); 
		query.append("           WHERE 1=1" ).append("\n"); 
		query.append("             AND BKG.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("             AND VVD.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("             AND BKG.BKG_NO = BD.BKG_NO" ).append("\n"); 
		query.append("             AND BC.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("             AND BCD.BKG_NO(+) = BC.BKG_NO" ).append("\n"); 
		query.append("             AND BCD.CNTR_NO(+) = BC.CNTR_NO" ).append("\n"); 
		query.append("             AND CUST1.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("             AND CUST1.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 
		query.append("             AND CUST2.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("             AND CUST2.BKG_CUST_TP_CD(+) = 'C'" ).append("\n"); 
		query.append("             AND CUST3.BKG_NO(+) = BKG.BKG_NO" ).append("\n"); 
		query.append("             AND CUST3.BKG_CUST_TP_CD(+) = 'N'" ).append("\n"); 
		query.append("             AND DG.BKG_NO(+) = BC.BKG_NO" ).append("\n"); 
		query.append("             AND DG.CNTR_NO(+) = BC.CNTR_NO" ).append("\n"); 
		query.append("             AND VVD.VSL_CD         = SKD1.VSL_CD" ).append("\n"); 
		query.append("             AND VVD.SKD_VOY_NO     = SKD1.SKD_VOY_NO" ).append("\n"); 
		query.append("             AND VVD.SKD_DIR_CD     = SKD1.SKD_DIR_CD" ).append("\n"); 
		query.append("             AND VVD.POL_CD         = SKD1.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND SKD1.CLPT_IND_SEQ  = 1" ).append("\n"); 
		query.append("    	 	 AND SKD2.VSL_CD=VVD.VSL_CD" ).append("\n"); 
		query.append("    		 AND SKD2.SKD_VOY_NO=VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("    		 AND SKD2.SKD_DIR_CD=VVD.SKD_DIR_CD " ).append("\n"); 
		query.append("    		 AND SKD2.CLPT_IND_SEQ  = 1" ).append("\n"); 
		query.append("    		 AND VVD.VSL_CD      = SKD3.VSL_CD" ).append("\n"); 
		query.append("    		 AND VVD.SKD_VOY_NO  = SKD3.SKD_VOY_NO" ).append("\n"); 
		query.append("    		 AND VVD.SKD_DIR_CD  = SKD3.SKD_DIR_CD" ).append("\n"); 
		query.append("    		 AND VVD.POD_CD      = SKD3.VPS_PORT_CD" ).append("\n"); 
		query.append("             AND VVD.POD_YD_CD   = SKD3.YD_CD " ).append("\n"); 
		query.append("    		 AND SKD2.CLPT_SEQ  <= SKD3.CLPT_SEQ  -- 1st EU Port 이후에 POD 기항해야함." ).append("\n"); 
		query.append("		#if (${p_pol_cd} != '') " ).append("\n"); 
		query.append("			AND VVD.POL_CD = @[p_pol_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		#if (${p_pol_yard_cd} != '') " ).append("\n"); 
		query.append("			AND SUBSTR(VVD.POL_YD_CD, -2) = @[p_pol_yard_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${p_search_pofe_yard_cd} != '') " ).append("\n"); 
		query.append("	      AND SKD2.VPS_PORT_CD = SUBSTR(@[p_search_pofe_yard_cd],1,5)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_cd} == 'F')" ).append("\n"); 
		query.append("   AND BKG.BKG_CGO_TP_CD IN ('F','R')" ).append("\n"); 
		query.append("#elseif (${bkg_cgo_tp_cd} == 'P')" ).append("\n"); 
		query.append("   AND BKG.BKG_CGO_TP_CD = 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("   AND BKG.BL_NO     =   @[bl_no]" ).append("\n"); 
		query.append("   AND (VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD) = (" ).append("\n"); 
		query.append("                    SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                      FROM BKG_BOOKING" ).append("\n"); 
		query.append("                     WHERE BL_NO = @[bl_no]" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("#elseif (${bkg_no} != '') " ).append("\n"); 
		query.append("   AND BKG.BKG_NO    =   @[bkg_no]" ).append("\n"); 
		query.append("   AND (VVD.VSL_CD,VVD.SKD_VOY_NO,VVD.SKD_DIR_CD) = (" ).append("\n"); 
		query.append("                    SELECT VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 
		query.append("                      FROM BKG_BOOKING" ).append("\n"); 
		query.append("                     WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("   AND VVD.VSL_CD    =   SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO=   SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD=   SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if ('' != ${bkg_nos})" ).append("\n"); 
		query.append("		AND BKG.BKG_NO IN (''" ).append("\n"); 
		query.append("		#foreach($bkg_no IN ${bkg_nos})" ).append("\n"); 
		query.append("			,'$bkg_no'" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${pol_cd} != '' && ${pod_cd} == '') " ).append("\n"); 
		query.append("        #if (${ts_search_flag} != 'T')" ).append("\n"); 
		query.append("            AND VVD.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("            AND VVD.POL_CD    =   BKG.POL_CD" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND VVD.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif (${pol_cd} == '' && ${pod_cd} != '') " ).append("\n"); 
		query.append("        #if (${ts_search_flag} != 'T')" ).append("\n"); 
		query.append("            AND VVD.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("            AND VVD.POD_CD    =   BKG.POD_CD" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND VVD.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif (${pol_cd} != '' && ${pod_cd} != '') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${ts_search_flag} != 'T')" ).append("\n"); 
		query.append("            AND VVD.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("            AND VVD.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("            AND VVD.POL_CD    =   BKG.POL_CD" ).append("\n"); 
		query.append("            AND VVD.POD_CD    =   BKG.POD_CD" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("            AND VVD.POL_CD    =   @[pol_cd]" ).append("\n"); 
		query.append("            AND VVD.POD_CD    =   @[pod_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${por_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.POR_CD    =   NVL(@[por_cd], BKG.POR_CD)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${del_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.DEL_CD    LIKE   @[del_cd] || '%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${pol_yd_cd} != '')" ).append("\n"); 
		query.append("       AND SUBSTR(VVD.POL_YD_CD, -2) = @[pol_yd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    #if (${pod_yd_cd} != '')" ).append("\n"); 
		query.append("       AND SUBSTR(VVD.POD_YD_CD, -2) = @[pod_yd_cd]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    #if (${bkg_sts_cd} != '') " ).append("\n"); 
		query.append("       AND BKG.BKG_STS_CD =   NVL(@[bkg_sts_cd], BKG.BKG_STS_CD)" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        ORDER BY VVD.VSL_CD," ).append("\n"); 
		query.append("                 VVD.SKD_VOY_NO," ).append("\n"); 
		query.append("                 VVD.SKD_DIR_CD," ).append("\n"); 
		query.append("                 VVD.BKG_NO," ).append("\n"); 
		query.append("                 BC.CNTR_NO) T" ).append("\n"); 

	}
}