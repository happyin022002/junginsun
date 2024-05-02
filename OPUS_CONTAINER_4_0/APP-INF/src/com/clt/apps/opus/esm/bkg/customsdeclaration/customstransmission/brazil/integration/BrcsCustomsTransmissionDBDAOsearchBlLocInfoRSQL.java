/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BrcsCustomsTransmissionDBDAOsearchBlLocInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.29
*@LastModifier : 이종길
*@LastVersion : 1.0
* 2016.08.29 이종길
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jong-Kil LEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BrcsCustomsTransmissionDBDAOsearchBlLocInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BL 일반 정보 및 location 정보를 조회한다.
	  * </pre>
	  */
	public BrcsCustomsTransmissionDBDAOsearchBlLocInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("receiver_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mode_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("search_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_gubun",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.brazil.integration").append("\n"); 
		query.append("FileName : BrcsCustomsTransmissionDBDAOsearchBlLocInfoRSQL").append("\n"); 
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
		query.append("WITH VSK_SKD_PORT AS " ).append("\n"); 
		query.append("(SELECT A.VSL_CD " ).append("\n"); 
		query.append("       ,A.SKD_VOY_NO" ).append("\n"); 
		query.append("       ,A.SKD_DIR_CD" ).append("\n"); 
		query.append("       ,A.SLAN_CD " ).append("\n"); 
		query.append("       ,A.VPS_PORT_CD " ).append("\n"); 
		query.append("       ,ROW_NUMBER() OVER (PARTITION BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) AS CLPT_SEQ" ).append("\n"); 
		query.append("       ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("FROM VSK_VSL_PORT_SKD A, BKG_VVD B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.VSL_CD = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND NVL(SKD_CNG_STS_CD, 'X') <> 'S'" ).append("\n"); 
		query.append("AND B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if(${mode_type}=='O')" ).append("\n"); 
		query.append("AND A.CLPT_IND_SEQ = B.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND A.CLPT_IND_SEQ = B.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #if (${cnt_gubun} == 'BR')" ).append("\n"); 
		query.append("SELECT    BK.BL_NO || DECODE(BK.BL_TP_CD, 'W', BK.BL_TP_CD)			   BLNBR" ).append("\n"); 
		query.append("         ,NVL(LOC1.UN_LOC_CD, BK.POL_CD)       BLPOL" ).append("\n"); 
		query.append("         ,NVL(LOC2.UN_LOC_CD, BK.POD_CD)       BLPOD" ).append("\n"); 
		query.append("         ,NVL(LOC3.UN_LOC_CD, BK.POR_CD)       BLPOR" ).append("\n"); 
		query.append("         ,NVL(LOC4.UN_LOC_CD, BK.DEL_CD)       BLDEL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,NVL(BBD.ACT_WGT, 0)       BLWGT" ).append("\n"); 
		query.append("        ,NVL(BBD.MEAS_QTY, 0)      BLMEA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,REPLACE(REPLACE(BKG_TOKEN_NL_FNC(NVL(BK.XTER_RMK,' '),0,''),'$','S'),'#',' ') REMARK" ).append("\n"); 
		query.append("		,NVL(CMD.MF_CMDT_CD,' ') IN_CMDT_CD" ).append("\n"); 
		query.append("		,'' IN_CMDT_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,'' COMMODITY" ).append("\n"); 
		query.append("        ,'' BLPOL_NODE" ).append("\n"); 
		query.append("        ,'' BLPOD_NODE" ).append("\n"); 
		query.append("        ,'' EU_ENTRY_OFC" ).append("\n"); 
		query.append("        ,'' EU_POD_OFC" ).append("\n"); 
		query.append("	    ,'' PART_LOAD" ).append("\n"); 
		query.append("        ,'' POFE_ETA" ).append("\n"); 
		query.append("        ,'' TRANSIT_IND" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,DECODE(BRC.SHPR_TAX_NO, NULL, BCS.CUST_CNT_CD, 'CNPJ')     	     SHPRCN     -- 브리질 전용" ).append("\n"); 
		query.append("	     ,DECODE(BRC.SHPR_TAX_NO, NULL, BCS.CUST_SEQ||'' , BRC.SHPR_TAX_NO)  SHPRCD		-- 브리질 전용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,DECODE(BRC.CNEE_TAX_NO, NULL, BCC.CUST_CNT_CD, 'CNPJ')     	     CNEECN     -- 브리질 전용" ).append("\n"); 
		query.append("	     ,DECODE(BRC.CNEE_TAX_NO, NULL, BCC.CUST_SEQ||'' , BRC.CNEE_TAX_NO)  CNEECD		-- 브리질 전용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 ,DECODE(BRC.NTFY_TAX_NO, NULL, BCN.CUST_CNT_CD, 'CNPJ')   		     NTFYCN  -- 브리질 전용" ).append("\n"); 
		query.append("		 ,DECODE(BRC.NTFY_TAX_NO, NULL, BCN.CUST_SEQ||'', BRC.NTFY_TAX_NO)   NTFYCD  -- 브리질 전용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 ,BRC.BRZ_DECL_NO						 EXPOCD" ).append("\n"); 
		query.append("         ,DECODE(BK.BL_TP_CD, 'W', 'W', '')    AS WAYBILL_IND" ).append("\n"); 
		query.append("         ,CASE WHEN BK.RCV_TERM_CD = 'S' OR BK.DE_TERM_CD = 'S'" ).append("\n"); 
		query.append("               THEN 'L'" ).append("\n"); 
		query.append("               ELSE 'F'" ).append("\n"); 
		query.append("           END FCL_LCL" ).append("\n"); 
		query.append("		,(SELECT TO_CHAR(BL_OBRD_DT,'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("          FROM BKG_BL_DOC" ).append("\n"); 
		query.append("          WHERE BKG_NO = @[bkg_no]) ONBOARD" ).append("\n"); 
		query.append("        #if(${ibflag}=='I')    -- IO_TYPE" ).append("\n"); 
		query.append("        ,(select case when max(v2.seq) >=2 then 'Y'" ).append("\n"); 
		query.append("                 else 'N'" ).append("\n"); 
		query.append("                 end TS_IND" ).append("\n"); 
		query.append("		  from" ).append("\n"); 
		query.append("		  (select level seq" ).append("\n"); 
		query.append("		   from   dual" ).append("\n"); 
		query.append("		   connect by level <= 5" ).append("\n"); 
		query.append("		   ) v1," ).append("\n"); 
		query.append("		  (select rownum seq" ).append("\n"); 
		query.append("		   from bkg_vvd vvd, vsk_vsl_port_skd vps_eta, vsk_vsl_port_skd vps_etd, bkg_booking bkg" ).append("\n"); 
		query.append("		   where vvd.vsl_cd     = vps_etd.vsl_cd(+)" ).append("\n"); 
		query.append("		   and vvd.skd_voy_no = vps_etd.skd_voy_no(+)" ).append("\n"); 
		query.append("		   and vvd.skd_dir_cd = vps_etd.skd_dir_cd(+)" ).append("\n"); 
		query.append("		   and vvd.pol_cd     = vps_etd.vps_port_cd(+)" ).append("\n"); 
		query.append("		   and nvl(vvd.POl_clpt_ind_seq,1) = vps_etd.clpt_ind_seq(+)" ).append("\n"); 
		query.append("	       and vvd.vsl_cd     = vps_eta.vsl_cd(+)" ).append("\n"); 
		query.append("		   and vvd.skd_voy_no = vps_eta.skd_voy_no(+)" ).append("\n"); 
		query.append("		   and vvd.skd_dir_cd = vps_eta.skd_dir_cd(+)" ).append("\n"); 
		query.append("		   and vvd.pod_cd     = vps_eta.vps_port_cd(+)" ).append("\n"); 
		query.append("		   and nvl(vvd.POD_clpt_ind_seq,1) = vps_eta.clpt_ind_seq(+)" ).append("\n"); 
		query.append("		   and vvd.bkg_no     = @[bkg_no]" ).append("\n"); 
		query.append("           and bkg.bkg_no     = vvd.bkg_no" ).append("\n"); 
		query.append("           and bkg.pod_cd     like 'BR%'" ).append("\n"); 
		query.append("		   order by VVD.BKG_NO,  vvd.vsl_pre_pst_cd, vvd.vsl_seq" ).append("\n"); 
		query.append("	       ) v2" ).append("\n"); 
		query.append("		   where v1.seq = v2.seq(+))AS TS_IND" ).append("\n"); 
		query.append("        ,'I' EX_IND" ).append("\n"); 
		query.append("        #else" ).append("\n"); 
		query.append("        , 'N' AS TS_IND" ).append("\n"); 
		query.append("		, 'E' EX_IND" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    #elseif (${cnt_gubun} == 'EUR')" ).append("\n"); 
		query.append("SELECT    BK.BL_NO			                   BLNBR" ).append("\n"); 
		query.append("         ,BK.POL_CD       					   BLPOL" ).append("\n"); 
		query.append("         ,LOC1.LOC_NM      					   BLPOL_NAME" ).append("\n"); 
		query.append("         ,BK.POD_CD       					   BLPOD" ).append("\n"); 
		query.append("         ,LOC2.LOC_NM      					   BLPOD_NAME" ).append("\n"); 
		query.append("         ,BK.POR_CD      					   BLPOR" ).append("\n"); 
		query.append("         ,LOC3.LOC_NM      					   BLPOR_NAME" ).append("\n"); 
		query.append("         ,BK.DEL_CD       					   BLDEL" ).append("\n"); 
		query.append("         ,LOC4.LOC_NM      					   BLDEL_NAME" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,DECODE(NVL(BBD.WGT_UT_CD,' '),'LBS',ROUND(NVL(BBD.ACT_WGT,0)*0.4536,3),NVL(BBD.ACT_WGT,0)) BLWGT" ).append("\n"); 
		query.append("        ,DECODE(NVL(BBD.MEAS_UT_CD,' '),'CBF',ROUND(NVL(BBD.MEAS_QTY,0)*0.0283,3),NVL(BBD.MEAS_QTY,0)) BLMEA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,BKG_TOKEN_NL_FNC(NVL(BK.XTER_RMK,' '),0,'') REMARK" ).append("\n"); 
		query.append("		,NVL(BK.CMDT_CD,' ') IN_CMDT_CD" ).append("\n"); 
		query.append("        ,BKG_TOKEN_NL_FNC(NVL(COM.CMDT_NM, ''),0,'') IN_CMDT_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,BK.CMDT_CD COMMODITY" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,BV.POL_YD_CD BLPOL_NODE" ).append("\n"); 
		query.append("		,BV.POD_YD_CD BLPOD_NODE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,(SELECT A.EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                         SELECT" ).append("\n"); 
		query.append("                            A.CSTMS_PORT_CD AS POFE" ).append("\n"); 
		query.append("                            ,A.CSTMS_YD_CD AS POFE_YD" ).append("\n"); 
		query.append("                            ,ROW_NUMBER() OVER ( ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) RN" ).append("\n"); 
		query.append("                         FROM (" ).append("\n"); 
		query.append("                              SELECT" ).append("\n"); 
		query.append("                                  DISTINCT A.VSL_CD ," ).append("\n"); 
		query.append("                                  A.SKD_VOY_NO ," ).append("\n"); 
		query.append("                                  A.SKD_DIR_CD ," ).append("\n"); 
		query.append("                                  CSTMS_PORT_CD ," ).append("\n"); 
		query.append("                                  CSTMS_YD_CD" ).append("\n"); 
		query.append("                                  ,CLPT_SEQ" ).append("\n"); 
		query.append("                                FROM BKG_CSTMS_EUR_BL A , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND A.VSL_CD= B.VSL_CD" ).append("\n"); 
		query.append("                                AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND A.CSTMS_PORT_cD = B.VPS_PORT_cD" ).append("\n"); 
		query.append("                                AND B.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                AND (A.BL_NO, NVL(A.MSG_SND_NO, ' ')) = (" ).append("\n"); 
		query.append("                                            SELECT A.BL_NO, NVL(MAX(A.MSG_SND_NO), ' ')" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_ADV_EUR_SND A" ).append("\n"); 
		query.append("                                            WHERE A.MSG_SND_NO LIKE (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) ||'%'" ).append("\n"); 
		query.append("                                            AND EUR_EDI_MSG_TP_ID = 'ENS'" ).append("\n"); 
		query.append("                                            GROUP BY A.BL_NO" ).append("\n"); 
		query.append("                       					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            ) A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    ) ENS  -- ENS 내역" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           WHERE A.PORT_CD = ENS.POFE" ).append("\n"); 
		query.append("             AND (A.TML_CD = ENS.POFE_YD OR A.TML_CD = 'ALL')" ).append("\n"); 
		query.append("        ) EU_ENTRY_OFC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,(SELECT A.EUR_CSTMS_OFC_NM" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("              , (" ).append("\n"); 
		query.append("                         SELECT" ).append("\n"); 
		query.append("                            A.CSTMS_PORT_CD AS POFE" ).append("\n"); 
		query.append("                            ,A.CSTMS_YD_CD AS POFE_YD" ).append("\n"); 
		query.append("                            ,ROW_NUMBER() OVER ( ORDER BY A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.CLPT_SEQ ) RN" ).append("\n"); 
		query.append("                         FROM (" ).append("\n"); 
		query.append("                              SELECT" ).append("\n"); 
		query.append("                                  DISTINCT A.VSL_CD ," ).append("\n"); 
		query.append("                                  A.SKD_VOY_NO ," ).append("\n"); 
		query.append("                                  A.SKD_DIR_CD ," ).append("\n"); 
		query.append("                                  CSTMS_PORT_CD ," ).append("\n"); 
		query.append("                                  CSTMS_YD_CD" ).append("\n"); 
		query.append("                                  ,CLPT_SEQ" ).append("\n"); 
		query.append("                                FROM BKG_CSTMS_EUR_BL A , VSK_VSL_PORT_SKD B" ).append("\n"); 
		query.append("                                WHERE 1=1" ).append("\n"); 
		query.append("                                AND A.VSL_CD= B.VSL_CD" ).append("\n"); 
		query.append("                                AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                                AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                                AND A.CSTMS_PORT_cD = B.VPS_PORT_cD" ).append("\n"); 
		query.append("                                AND B.CLPT_IND_SEQ = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                                AND (A.BL_NO, NVL(A.MSG_SND_NO, ' ')) = (" ).append("\n"); 
		query.append("                                            SELECT A.BL_NO, NVL(MAX(A.MSG_SND_NO), ' ')" ).append("\n"); 
		query.append("                                            FROM BKG_CSTMS_ADV_EUR_SND A" ).append("\n"); 
		query.append("                                            WHERE A.MSG_SND_NO LIKE (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) ||'%'" ).append("\n"); 
		query.append("                                            AND EUR_EDI_MSG_TP_ID = 'ENS'" ).append("\n"); 
		query.append("                                            GROUP BY A.BL_NO" ).append("\n"); 
		query.append("                       					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                            ) A" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("                    ) ENS  -- ENS 내역" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("           WHERE A.PORT_CD = ENS.POFE" ).append("\n"); 
		query.append("             AND (A.TML_CD = ENS.POFE_YD OR A.TML_CD = 'ALL')" ).append("\n"); 
		query.append("        ) EU_ENTRY_OFC_NAME" ).append("\n"); 
		query.append("		,(" ).append("\n"); 
		query.append("            SELECT EUR_CSTMS_OFC_ID" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_EUR_CD_STUP A" ).append("\n"); 
		query.append("            WHERE A.PORT_CD = BV.POD_CD" ).append("\n"); 
		query.append("            AND (A.TML_CD = BV.POD_YD_CD OR A.TML_CD = 'ALL')" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("		) AS EU_POD_OFC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, (" ).append("\n"); 
		query.append("			SELECT DECODE(SUM(DECODE(CNTR_PRT_FLG, 'Y', 1, 0)), 0, 'N', 'Y')" ).append("\n"); 
		query.append("			FROM BKG_CONTAINER" ).append("\n"); 
		query.append("			WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		) PART_LOAD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        , (" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            SELECT NVL(TO_CHAR(CSTMS_ESTM_ARR_DT,'YYYYMMDDHH24MI'),' ')" ).append("\n"); 
		query.append("            FROM BKG_CSTMS_EUR_BL" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND MSG_SND_NO = (" ).append("\n"); 
		query.append("                            SELECT MAX(MSG_SND_NO)" ).append("\n"); 
		query.append("                            FROM BKG_CSTMS_ADV_EUR_SND A" ).append("\n"); 
		query.append("                            WHERE A.MSG_SND_NO LIKE (SELECT BL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]) ||'%'" ).append("\n"); 
		query.append("                            AND EUR_EDI_MSG_TP_ID = 'ENS'" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("		    AND ROWNUM = 1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ) AS POFE_ETA" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${mode_type} == 'I')" ).append("\n"); 
		query.append("		,NVL((" ).append("\n"); 
		query.append("		      SELECT 'Y'" ).append("\n"); 
		query.append("		      FROM BKG_VVD BV" ).append("\n"); 
		query.append("		      WHERE 1=1" ).append("\n"); 
		query.append("		      AND (BV.POD_YD_CD, BV.POD_CLPT_IND_SEQ) IN ( SELECT YD_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                             FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                            WHERE VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                              AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                              AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                              AND CLPT_SEQ > ( SELECT MIN(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                                 FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                                WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                                  AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                                  AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                                                  AND VPS_PORT_CD = @[search_pod_cd]" ).append("\n"); 
		query.append("                                                                                  AND YD_CD = BV.POD_YD_CD" ).append("\n"); 
		query.append("                                                                                  AND CLPT_IND_SEQ  = BV.POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                                  AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                                                             )" ).append("\n"); 
		query.append("                                                              AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("		      AND BV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND BV.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		      AND BV.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		      AND BV.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("		      AND ROWNUM = 1" ).append("\n"); 
		query.append("		), 'N') AS TRANSIT_IND" ).append("\n"); 
		query.append("	#else" ).append("\n"); 
		query.append("		,NVL((" ).append("\n"); 
		query.append("		      SELECT 'Y'" ).append("\n"); 
		query.append("		      FROM BKG_VVD BV" ).append("\n"); 
		query.append("		      WHERE 1=1" ).append("\n"); 
		query.append("		      AND (BV.POL_YD_CD, BV.POL_CLPT_IND_SEQ) IN ( SELECT YD_CD, CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                             FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                            WHERE VSL_CD     = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                              AND SKD_VOY_NO = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                              AND SKD_DIR_CD = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                              AND CLPT_SEQ < ( SELECT MAX(CLPT_SEQ)" ).append("\n"); 
		query.append("                                                                                 FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("                                                                                WHERE VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("                                                                                  AND SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("                                                                                  AND SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("                                                                                  AND VPS_PORT_CD = @[search_pod_cd]" ).append("\n"); 
		query.append("                                                                                  AND YD_CD = BV.POL_YD_CD" ).append("\n"); 
		query.append("                                                                                  AND CLPT_IND_SEQ  = BV.POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append("                                                                                  AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                                                             )" ).append("\n"); 
		query.append("                                                              AND NVL(SKD_CNG_STS_CD,'X') <> 'S'" ).append("\n"); 
		query.append("                                                         )" ).append("\n"); 
		query.append("		      AND BV.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("              AND BV.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("		      AND BV.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("		      AND BV.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("		      AND ROWNUM = 1" ).append("\n"); 
		query.append("		), 'N') AS TRANSIT_IND" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		,(CASE WHEN BV.POD_YD_CD <>  BK.POD_NOD_CD THEN 'T'" ).append("\n"); 
		query.append("		       WHEN @[mode_type] = 'O' " ).append("\n"); 
		query.append("		            AND BK.POR_CD <> BV.POL_CD" ).append("\n"); 
		query.append("		            AND BV.POL_CD LIKE 'DE%'" ).append("\n"); 
		query.append("		            AND BK.ORG_TRNS_MOD_CD IN ('F', 'B','U','E')" ).append("\n"); 
		query.append("		       THEN 'T'" ).append("\n"); 
		query.append("			ELSE" ).append("\n"); 
		query.append("			#if (${mode_type} == 'I')" ).append("\n"); 
		query.append("				DECODE(BV.POD_CD, @[search_pod_cd], '', 'F')" ).append("\n"); 
		query.append("			#else" ).append("\n"); 
		query.append("				DECODE(BV.POL_CD, @[search_pod_cd], '', 'F')" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			END" ).append("\n"); 
		query.append("		) AS  TRANSHIP_IND" ).append("\n"); 
		query.append("		 ,DECODE(@[mode_type], 'I', 'I', 'E') INOUT_IND" ).append("\n"); 
		query.append("         ,BCS.CUST_CNT_CD SHPRCN" ).append("\n"); 
		query.append("	     ,BCS.CUST_SEQ    SHPRCD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,BCC.CUST_CNT_CD CNEECN" ).append("\n"); 
		query.append("	     ,BCC.CUST_SEQ    CNEECD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 ,BCN.CUST_CNT_CD NTFYCN" ).append("\n"); 
		query.append("		 ,BCN.CUST_SEQ    NTFYCD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		, '' EXPOCD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,LOC1.LOC_AMS_PORT_CD                 POL_AMS" ).append("\n"); 
		query.append("         ,LOC1.LOC_NM                          POL_FULLNAME" ).append("\n"); 
		query.append("         ,LOC2.LOC_AMS_PORT_CD                 POD_AMS" ).append("\n"); 
		query.append("         ,LOC2.LOC_NM                          POD_FULLNAME" ).append("\n"); 
		query.append("         ,LOC3.LOC_AMS_PORT_CD                 POR_AMS" ).append("\n"); 
		query.append("         ,LOC3.LOC_NM                          POR_FULLNAME" ).append("\n"); 
		query.append("         ,LOC4.LOC_AMS_PORT_CD                 DEL_AMS" ).append("\n"); 
		query.append("         ,LOC4.LOC_NM                          DEL_FULLNAME" ).append("\n"); 
		query.append("   		 #if (${cnt_gubun} == 'EUR')" ).append("\n"); 
		query.append("         ,(SELECT VPS_PORT_CD" ).append("\n"); 
		query.append("           FROM VSK_SKD_PORT" ).append("\n"); 
		query.append("           WHERE CLPT_SEQ = (SELECT CLPT_SEQ-1" ).append("\n"); 
		query.append("                             FROM VSK_SKD_PORT" ).append("\n"); 
		query.append("			   	             WHERE 1=1 " ).append("\n"); 
		query.append("			  	             #if(${mode_type}=='O')" ).append("\n"); 
		query.append("			 	             AND VPS_PORT_CD = @[pol_cd]" ).append("\n"); 
		query.append("			                 #else" ).append("\n"); 
		query.append("				             AND VPS_PORT_CD = @[pod_cd]" ).append("\n"); 
		query.append("		                     #end)" ).append("\n"); 
		query.append("          )BLRLY		" ).append("\n"); 
		query.append("         #elseif (${cnt_gubun} == 'BR')" ).append("\n"); 
		query.append("         ,DECODE(NVL(@[pol_cd],''), '', NVL(LOC5.UN_LOC_CD, BK.PST_RLY_PORT_CD), NVL(LOC5.UN_LOC_CD, BK.PRE_RLY_PORT_CD)) BLRLY" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         ,LOC5.LOC_AMS_PORT_CD RLY_AMS" ).append("\n"); 
		query.append("         ,LOC5.LOC_NM        RLY_FULLNAME" ).append("\n"); 
		query.append("         ,OFC.LOC_CD         BLPLACE" ).append("\n"); 
		query.append("         ,TO_CHAR(BBI.OBL_ISS_DT,'RRMMDD')        BLDATE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCS.CUST_NM, 1, '')        SHPR1" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCS.CUST_NM, 2, '')        SHPR2" ).append("\n"); 
		query.append("         #if (${cnt_gubun} == 'BR')" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCS.CUST_ADDR, 1, '')      SHPR3" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCS.CUST_ADDR, 2, '')      SHPR4" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCS.CUST_ADDR, 3, '')      SHPR5" ).append("\n"); 
		query.append("         #elseif (${cnt_gubun} == 'EUR')" ).append("\n"); 
		query.append("         ,NVL2(BCS.EUR_CSTMS_ST_NM||BCS.CUST_CTY_NM||BCS.CUST_ZIP_ID, BCS.EUR_CSTMS_ST_NM, BKG_TOKEN_NL_FNC(BCS.CUST_ADDR, 1, '')) SHPR3 -- STREET" ).append("\n"); 
		query.append("         ,NVL2(BCS.EUR_CSTMS_ST_NM||BCS.CUST_CTY_NM||BCS.CUST_ZIP_ID, BCS.CUST_CTY_NM, BKG_TOKEN_NL_FNC(BCS.CUST_ADDR, 2, ''))     SHPR4 -- CITY" ).append("\n"); 
		query.append("         ,NVL2(BCS.EUR_CSTMS_ST_NM||BCS.CUST_CTY_NM||BCS.CUST_ZIP_ID, BCS.CUST_ZIP_ID, BKG_TOKEN_NL_FNC(BCS.CUST_ADDR, 3, ''))     SHPR5 -- ZIP CODE" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCC.CUST_NM, 1, '')        CNEE1" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCC.CUST_NM, 2, '')        CNEE2" ).append("\n"); 
		query.append("         #if (${cnt_gubun} == 'BR')" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCC.CUST_ADDR, 1, '')      CNEE3" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCC.CUST_ADDR, 2, '')      CNEE4" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCC.CUST_ADDR, 3, '')      CNEE5" ).append("\n"); 
		query.append("         #elseif (${cnt_gubun} == 'EUR')" ).append("\n"); 
		query.append("         ,NVL2(BCC.EUR_CSTMS_ST_NM||BCC.CUST_CTY_NM||BCC.CUST_ZIP_ID, BCC.EUR_CSTMS_ST_NM, BKG_TOKEN_NL_FNC(BCC.CUST_ADDR, 1, '')) CNEE3 -- STREET" ).append("\n"); 
		query.append("         ,NVL2(BCC.EUR_CSTMS_ST_NM||BCC.CUST_CTY_NM||BCC.CUST_ZIP_ID, BCC.CUST_CTY_NM, BKG_TOKEN_NL_FNC(BCC.CUST_ADDR, 2, ''))     CNEE4 -- CITY" ).append("\n"); 
		query.append("         ,NVL2(BCC.EUR_CSTMS_ST_NM||BCC.CUST_CTY_NM||BCC.CUST_ZIP_ID, BCC.CUST_ZIP_ID, BKG_TOKEN_NL_FNC(BCC.CUST_ADDR, 3, ''))     CNEE5 -- ZIP CODE" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCN.CUST_NM, 1, '')        NTFY1" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCN.CUST_NM, 2, '')        NTFY2" ).append("\n"); 
		query.append("         #if (${cnt_gubun} == 'BR')" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCN.CUST_ADDR, 1, '')      NTFY3" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCN.CUST_ADDR, 2, '')      NTFY4" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCN.CUST_ADDR, 3, '')      NTFY5" ).append("\n"); 
		query.append("         #elseif (${cnt_gubun} == 'EUR')" ).append("\n"); 
		query.append("         ,NVL2(BCN.EUR_CSTMS_ST_NM||BCN.CUST_CTY_NM||BCN.CUST_ZIP_ID, BCN.EUR_CSTMS_ST_NM, BKG_TOKEN_NL_FNC(BCN.CUST_ADDR, 1, '')) NTFY3 -- STREET" ).append("\n"); 
		query.append("         ,NVL2(BCN.EUR_CSTMS_ST_NM||BCN.CUST_CTY_NM||BCN.CUST_ZIP_ID, BCN.CUST_CTY_NM, BKG_TOKEN_NL_FNC(BCN.CUST_ADDR, 2, ''))     NTFY4 -- CITY" ).append("\n"); 
		query.append("         ,NVL2(BCN.EUR_CSTMS_ST_NM||BCN.CUST_CTY_NM||BCN.CUST_ZIP_ID, BCN.CUST_ZIP_ID, BKG_TOKEN_NL_FNC(BCN.CUST_ADDR, 3, ''))     NTFY5 -- ZIP CODE" ).append("\n"); 
		query.append("         #end" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         ,BCA.CUST_CNT_CD    NTFY2CN" ).append("\n"); 
		query.append("         ,BCA.CUST_SEQ      NTFY2NM" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCA.CUST_NM, 1, '')       NTFY21" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCA.CUST_NM, 2, '')       NTFY22" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCA.CUST_ADDR, 1, '')     NTFY23" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCA.CUST_ADDR, 2, '')     NTFY24" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCA.CUST_ADDR, 3, '')     NTFY25" ).append("\n"); 
		query.append("         ,BCF.CUST_CNT_CD   FFWDCN" ).append("\n"); 
		query.append("         ,BCF.CUST_SEQ      FFWDCD" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCF.CUST_NM, 1, '')       FFWD1" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCF.CUST_NM, 2, '')       FFWD2" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCF.CUST_NM, 3, '')       FFWD3" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCF.CUST_NM, 4, '')       FFWD4" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCF.CUST_NM, 5, '')       FFWD5" ).append("\n"); 
		query.append("         ,'DDE'             EXPOCN                          -- 브리질 전용" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCE.CUST_NM, 1, '')       EXPO1              -- 구주 전용 / 브라질은 값만 없음" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCE.CUST_NM, 2, '')       EXPO2              -- 구주 전용 / 브라질은 값만 없음" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCE.CUST_NM, 3, '')       EXPO3              -- 구주 전용 / 브라질은 값만 없음" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCE.CUST_NM, 4, '')       EXPO4              -- 구주 전용 / 브라질은 값만 없음" ).append("\n"); 
		query.append("         ,BKG_TOKEN_NL_FNC(BCE.CUST_NM, 5, '')       EXPO5              -- 구주 전용 / 브라질은 값만 없음" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,BBI.BL_CPY_KNT            BLCOPY" ).append("\n"); 
		query.append("         ,BBD.PCK_QTY               BLPKG" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("         ,NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("                 FROM BKG_CSTMS_PCK_TP_CONV AA" ).append("\n"); 
		query.append("                WHERE AA.CNT_CD = SUBSTR(@[cnt_gubun], 1 , 2)" ).append("\n"); 
		query.append("                  AND AA.RCVR_ID = DECODE(@[cnt_gubun], 'BR', 'ALL', DECODE(@[receiver_id], 'IMP', 'IMP', 'EU'))" ).append("\n"); 
		query.append("                  AND AA.PCK_TP_CD = BBD.PCK_TP_CD" ).append("\n"); 
		query.append("               ),BBD.PCK_TP_CD) AS BLPKGU" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		 ,BV.VSL_CD || BV.SKD_VOY_NO || BV.SKD_DIR_CD TRUNK_VVD    -- 구주 전용 / 브라질은 값만 없음" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,BBD.WGT_UT_CD             		BL_WGT_UNIT" ).append("\n"); 
		query.append("         ,BBD.MEAS_UT_CD                    BL_MEA_UNIT" ).append("\n"); 
		query.append("         ,BK.RCV_TERM_CD || BK.DE_TERM_CD   RDTYPE" ).append("\n"); 
		query.append("         ,BK.BKG_CGO_TP_CD          	    CARGOTYPE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,'' BLCMD" ).append("\n"); 
		query.append("         ,'' BLREPCMDCD" ).append("\n"); 
		query.append("         ,'' AUS_QUAR" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("         ,'' 				TMP_COL1" ).append("\n"); 
		query.append("         ,'' 				TMP_COL2" ).append("\n"); 
		query.append("         ,''                TMP_COL3" ).append("\n"); 
		query.append("         ,''                TMP_COL4" ).append("\n"); 
		query.append("         ,BK.BKG_NO			BKGNBR" ).append("\n"); 
		query.append("         ,'' RGN_BKGNBR" ).append("\n"); 
		query.append("         ,BR.PPD_RCV_OFC_CD PPDOFC" ).append("\n"); 
		query.append("         ,BR.CLT_OFC_CD     CCTOFC" ).append("\n"); 
		query.append("         ,'USA'             THDOFC" ).append("\n"); 
		query.append("         ,BK.SC_NO          SCNO" ).append("\n"); 
		query.append("         ,BK.RFA_NO         RFANO" ).append("\n"); 
		query.append("         ,(" ).append("\n"); 
		query.append("            --SELECT  DECODE(NVL(MAX(HIS_SEQ), '0'), '0', 'N', 'U') EDI_SEND_FLAG" ).append("\n"); 
		query.append("            SELECT  NVL(MAX(HIS_SEQ), '0') EDI_SEND_FLAG" ).append("\n"); 
		query.append("    		FROM	BKG_NTC_HIS" ).append("\n"); 
		query.append("    		WHERE	BKG_NO	= @[bkg_no]" ).append("\n"); 
		query.append("    		AND	NTC_KND_CD	= 'IM'" ).append("\n"); 
		query.append("    		AND	EDI_ID	    = 'BRSAO'" ).append("\n"); 
		query.append("    	   ) CUSTREF_NUM" ).append("\n"); 
		query.append("         ,BK.MTY_PKUP_YD_CD EQREL" ).append("\n"); 
		query.append("         ,TO_CHAR(BK.MTY_PKUP_DT, 'YYYYMMDDHH24MI')    EQPICKDT" ).append("\n"); 
		query.append("         ,BK.MTY_RTN_YD_CD  EQRTN" ).append("\n"); 
		query.append("		 ,NVL(BK.BL_NO,' ') IN_BL_NO" ).append("\n"); 
		query.append("		 ,NVL(BK.BKG_NO,' ') IN_BKG_NO" ).append("\n"); 
		query.append("		 ,NVL(BK.BKG_CGO_TP_CD,' ') IN_BKG_CGO_TP_CD" ).append("\n"); 
		query.append("		 ,NVL(BK.DCGO_FLG,' ') IN_DCGO_FLG" ).append("\n"); 
		query.append("		 ,NVL(BK.RC_FLG,' ') IN_RC_FLG" ).append("\n"); 
		query.append("		 ,NVL(BK.AWK_CGO_FLG,' ') IN_AWK_CGO_FLG" ).append("\n"); 
		query.append("		 ,NVL(BK.BB_CGO_FLG,' ') IN_BB_CGO_FLG" ).append("\n"); 
		query.append("		 ,NVL(BK.RD_CGO_FLG,' ') IN_RD_CGO_FLG" ).append("\n"); 
		query.append("         ,(" ).append("\n"); 
		query.append("            SELECT BRZ_CSTMS_DUV_NM FROM BKG_CSTMS_BRZ_BL BRC" ).append("\n"); 
		query.append("            WHERE  BRC.BL_NO = BK.BL_NO" ).append("\n"); 
		query.append("          ) BR_DUV                                          -- 브리질 전용" ).append("\n"); 
		query.append("         ,(" ).append("\n"); 
		query.append("            SELECT BRZ_CSTMS_MF_ID FROM BKG_CSTMS_BRZ_BL BRC" ).append("\n"); 
		query.append("            WHERE  BRC.BL_NO = BK.BL_NO" ).append("\n"); 
		query.append("          ) BR_MID                                          -- 브리질 전용" ).append("\n"); 
		query.append("  FROM" ).append("\n"); 
		query.append("        BKG_VVD BV" ).append("\n"); 
		query.append("        ,BKG_BOOKING BK" ).append("\n"); 
		query.append("        ,BKG_BL_ISS  BBI" ).append("\n"); 
		query.append("        ,BKG_BL_DOC  BBD" ).append("\n"); 
		query.append("        ,BKG_RATE    BR" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCS" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCC" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCN" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCF" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCA" ).append("\n"); 
		query.append("        ,BKG_CUSTOMER BCE" ).append("\n"); 
		query.append("        ,BKG_CSTMS_CMDT   CMD" ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC0" ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC1" ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC2" ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC3" ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC4" ).append("\n"); 
		query.append("        ,MDM_LOCATION     LOC5" ).append("\n"); 
		query.append("        ,MDM_ORGANIZATION OFC" ).append("\n"); 
		query.append("        ,MDM_COMMODITY    COM" ).append("\n"); 
		query.append("    #if (${cnt_gubun} == 'BR')" ).append("\n"); 
		query.append("	    ,BKG_CSTMS_BRZ_BL BRC" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append(" WHERE   BK.BKG_NO          =   @[bkg_no]" ).append("\n"); 
		query.append("   AND   BV.VSL_CD      = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("   AND   BV.SKD_VOY_NO  = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("   AND   BV.SKD_DIR_CD  = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BV.BKG_NO" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BBI.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BBD.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BR.BKG_NO		(+)" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCS.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCS.BKG_CUST_TP_CD =   'S'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCC.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCC.BKG_CUST_TP_CD(+) =   'C'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCN.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCN.BKG_CUST_TP_CD(+) =   'N'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCF.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCF.BKG_CUST_TP_CD(+) =   'F'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCA.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCA.BKG_CUST_TP_CD(+) =   'A'" ).append("\n"); 
		query.append("   AND   BK.BKG_NO          =   BCE.BKG_NO      (+)" ).append("\n"); 
		query.append("   AND   BCE.BKG_CUST_TP_CD(+) =   'E'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("   AND   LOC0.LOC_CD(+)     =   DECODE(NVL(@[pol_cd],''), '', BV.POL_CD, BV.POD_CD)" ).append("\n"); 
		query.append("   AND   BK.POR_CD         =   LOC3.LOC_CD  (+)" ).append("\n"); 
		query.append("   AND   BK.POL_CD         =   LOC1.LOC_CD  (+)" ).append("\n"); 
		query.append("   AND   BK.POD_CD         =   LOC2.LOC_CD  (+)" ).append("\n"); 
		query.append("   AND   BK.DEL_CD         =   LOC4.LOC_CD  (+)" ).append("\n"); 
		query.append("   AND   LOC5.LOC_CD(+)    = DECODE(NVL(@[pol_cd],''), '', NVL(BK.PST_RLY_PORT_CD,' '),NVL(BK.PRE_RLY_PORT_CD,' '))" ).append("\n"); 
		query.append("   AND   BBI.OBL_ISS_OFC_CD      = OFC.OFC_CD(+)" ).append("\n"); 
		query.append("   AND   BK.CMDT_CD         = COM.CMDT_CD(+)" ).append("\n"); 
		query.append("   AND   BK.CMDT_CD         = CMD.MF_CMDT_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cnt_gubun} == 'BR')" ).append("\n"); 
		query.append("   AND   BK.BL_NO 			= BRC.BL_NO(+)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND   ROWNUM = 1" ).append("\n"); 

	}
}