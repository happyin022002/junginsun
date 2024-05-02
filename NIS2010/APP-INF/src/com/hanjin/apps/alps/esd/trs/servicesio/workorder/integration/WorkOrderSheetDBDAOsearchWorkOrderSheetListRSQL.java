/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.17
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.17 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderSheetDBDAOsearchWorkOrderSheetListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchWorkOrderSheetList
	  * </pre>
	  */
	public WorkOrderSheetDBDAOsearchWorkOrderSheetListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_cmb_srt_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : WorkOrderSheetDBDAOsearchWorkOrderSheetListRSQL").append("\n"); 
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
		query.append("SELECT   CNTR_SEQ AS RNUM" ).append("\n"); 
		query.append("        ,Equipment_Number" ).append("\n"); 
		query.append("        ,Type_Size" ).append("\n"); 
		query.append("        ,Rate" ).append("\n"); 
		query.append("        ,Special_Cargo" ).append("\n"); 
		query.append("        ,Weight" ).append("\n"); 
		query.append("        ,Commodity_Description" ).append("\n"); 
		query.append("        ,Inbond_Transit_Number" ).append("\n"); 
		query.append("        ,Purchase_Order_No" ).append("\n"); 
		query.append("        ,Booking_Number" ).append("\n"); 
		query.append("        ,BL_NO" ).append("\n"); 
		query.append("        ,Vessel" ).append("\n"); 
		query.append("        ,next_port" ).append("\n"); 
		query.append("        ,Shipper_Name" ).append("\n"); 
		query.append("        ,Shipper_Telephone_Number" ).append("\n"); 
		query.append("        ,Door_Service_Type" ).append("\n"); 
		query.append("        --,Pickup_No" ).append("\n"); 
		query.append("        ,Available_Date" ).append("\n"); 
		query.append("        ,Last_Free_Date" ).append("\n"); 
		query.append("        ,f" ).append("\n"); 
		query.append("        ,o" ).append("\n"); 
		query.append("        ,c" ).append("\n"); 
		query.append("        ,CS_Clear_NO" ).append("\n"); 
		query.append("        ,Expected_Departure_Time" ).append("\n"); 
		query.append("        ,Expected_Arrival_Time" ).append("\n"); 
		query.append("        ,Door_Arrival_Appointment_Time" ).append("\n"); 
		query.append("        ,USA_Last_City" ).append("\n"); 
		query.append("        ,BLCK_STWG" ).append("\n"); 
		query.append("        ,DEL_CD" ).append("\n"); 
		query.append("        ,Remark" ).append("\n"); 
		query.append("        ,Predispatch" ).append("\n"); 
		query.append("        ,Seal_No_1" ).append("\n"); 
		query.append("        ,Seal_No_2" ).append("\n"); 
		query.append("        ,Detain" ).append("\n"); 
		query.append("        ,Bnum" ).append("\n"); 
		query.append("        ,MIN(DECODE(MLT_STOP_DE_FLG,'Y',DECODE(multi.TRO_SUB_SEQ,1,'ADDR : '||DOR_ADDR||' ('||multi.LOC_CD||') / '||TO_CHAR(multi.ARR_DT,'YYYY-MM-DD HH24:MI')||CHR(10)),'')) AS MLT_STOP_1" ).append("\n"); 
		query.append("        ,MIN(DECODE(MLT_STOP_DE_FLG,'Y',DECODE(multi.TRO_SUB_SEQ,2,'ADDR : '||DOR_ADDR||' ('||multi.LOC_CD||') / '||TO_CHAR(multi.ARR_DT,'YYYY-MM-DD HH24:MI')||CHR(10)),'')) AS MLT_STOP_2" ).append("\n"); 
		query.append("        ,MIN(DECODE(MLT_STOP_DE_FLG,'Y',DECODE(multi.TRO_SUB_SEQ,3,'ADDR : '||DOR_ADDR||' ('||multi.LOC_CD||') / '||TO_CHAR(multi.ARR_DT,'YYYY-MM-DD HH24:MI')||CHR(10)),'')) AS MLT_STOP_3" ).append("\n"); 
		query.append("        ,MIN(DECODE(MLT_STOP_DE_FLG,'Y',DECODE(multi.TRO_SUB_SEQ,4,'ADDR : '||DOR_ADDR||' ('||multi.LOC_CD||') / '||TO_CHAR(multi.ARR_DT,'YYYY-MM-DD HH24:MI')||CHR(10)),'')) AS MLT_STOP_4" ).append("\n"); 
		query.append("        ,MIN(DECODE(MLT_STOP_DE_FLG,'Y',DECODE(multi.TRO_SUB_SEQ,5,'PLEASE, CONTACT P.I.C. FOR MORE...'),'')) AS MLT_STOP_5" ).append("\n"); 
		query.append("        ,CNTR.bkg_no" ).append("\n"); 
		query.append("		,TRO_LOD_REF_NO" ).append("\n"); 
		query.append("		,Rail_Receiving_Date_FM" ).append("\n"); 
		query.append("		,Rail_Receiving_Date_TO" ).append("\n"); 
		query.append("		,CASE WHEN (f||o||c = 'YYY' OR f||o||c = 'YYW')" ).append("\n"); 
		query.append("  	   	 	   AND Pickup_No IS NOT NULL" ).append("\n"); 
		query.append("  	   	 	   AND Pickup_No <> ' '" ).append("\n"); 
		query.append("			   AND Last_Free_Date IS NOT NULL " ).append("\n"); 
		query.append("			   AND Last_Free_Date <> ' ' THEN Pickup_No" ).append("\n"); 
		query.append("--  	   	 AND ctmsts_id_cnt < 1 THEN Pickup_No WHEN (f||o||c = 'YYY'" ).append("\n"); 
		query.append("--         	OR f||o||c = 'YYW')" ).append("\n"); 
		query.append("--  	   	 AND Pickup_No IS NOT NULL" ).append("\n"); 
		query.append("--  	   	 AND Pickup_No <> ' '" ).append("\n"); 
		query.append("--  	   	 AND ctmsts_id_cnt >= 1 " ).append("\n"); 
		query.append("		 	   ELSE '' " ).append("\n"); 
		query.append("		 END AS Pickup_No" ).append("\n"); 
		query.append("--  	  	,CASE WHEN (f||o||c = 'YYY'" ).append("\n"); 
		query.append("--      		OR f||o||c = 'YYW')" ).append("\n"); 
		query.append("--  	   	 AND Pickup_No IS NOT NULL" ).append("\n"); 
		query.append("--  	   	 AND Pickup_No <> ' '" ).append("\n"); 
		query.append("--  	   	 AND ctmsts_id_cnt < 1 THEN Available_Date ELSE '' END AS Available_Date" ).append("\n"); 
		query.append("--  	  	,CASE WHEN (f||o||c = 'YYY'" ).append("\n"); 
		query.append("--     		OR f||o||c = 'YYW')" ).append("\n"); 
		query.append("--  	   	 AND Pickup_No IS NOT NULL" ).append("\n"); 
		query.append("--  	   	 AND Pickup_No <> ' '" ).append("\n"); 
		query.append("--       	 AND ctmsts_id_cnt < 1 THEN Last_Free_Date ELSE '' END AS Last_Free_Date" ).append("\n"); 
		query.append("FROM   (SELECT SO.EQ_NO AS Equipment_Number" ).append("\n"); 
		query.append("              ,TPSZ.CNTR_TPSZ_RMK AS Type_Size" ).append("\n"); 
		query.append("              ,SO.CURR_CD ||' '|| TO_CHAR(NVL(SO.BZC_AMT,0)+NVL(SO.ETC_ADD_AMT,0)+NVL(SO.FUEL_SCG_AMT,0)+NVL(SO.NEGO_AMT,0)+NVL(SO.TOLL_FEE_AMT,0)) AS Rate" ).append("\n"); 
		query.append("              ,SPCL_CGO_CNTR_TP_CD AS Special_Cargo" ).append("\n"); 
		query.append("              ,TPSZ.CNTR_TPSZ_TARE_WGT || ' / ' || SO.CNTR_WGT || ' '|| SO.WGT_MEAS_UT_CD AS Weight" ).append("\n"); 
		query.append("              ,CMDT.CMDT_NM|| ' /'||TO_CHAR(BKG_CNTR.PCK_QTY) || ' ' ||BKG_CNTR.PCK_TP_CD AS Commodity_Description" ).append("\n"); 
		query.append("              ,'' AS Inbond_Transit_Number" ).append("\n"); 
		query.append("			  ,(SELECT PU.CUST_REF_NO_CTNT" ).append("\n"); 
		query.append("         	      FROM BKG_REFERENCE PU" ).append("\n"); 
		query.append("                 WHERE PU.BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("         	       AND PU.CNTR_NO = SO.EQ_NO " ).append("\n"); 
		query.append("         	       AND PU.BKG_REF_TP_CD = 'CTPO' ) AS Purchase_Order_No" ).append("\n"); 
		query.append("              ,SO.BKG_NO AS Booking_Number" ).append("\n"); 
		query.append("              ,BKG.BL_NO AS BL_NO" ).append("\n"); 
		query.append("              ,VSL.VSL_ENG_NM||' '||SO.SKD_VOY_NO||SO.SKD_DIR_CD AS Vessel" ).append("\n"); 
		query.append("              ,DECODE(SO.TRSP_NXT_PORT_CD,NULL,LOC2.LOC_NM||'('||SO.POD_CD||')',LOC1.LOC_NM||'('||SO.TRSP_NXT_PORT_CD||')') AS next_port" ).append("\n"); 
		query.append("              ,CUST.CUST_LGL_ENG_NM AS Shipper_Name" ).append("\n"); 
		query.append("              ,CUST_CNTC.PHN_NO AS Shipper_Telephone_Number" ).append("\n"); 
		query.append("              ,(select	intg_cd_val_dp_desc	from com_intg_cd_dtl  where	intg_cd_id = 'CD00284' and	intg_cd_val_ctnt = SO.DOR_SVC_TP_CD) AS Door_Service_Type" ).append("\n"); 
		query.append("              ,pu.pkup_no AS Pickup_No" ).append("\n"); 
		query.append("			  ,to_char(pu.PKUP_AVAL_DT,'YYYY-MM-DD HH24:MI:SS') Available_Date" ).append("\n"); 
		query.append("        	  ,to_char(pu.LST_FREE_DT,'YYYY-MM-DD HH24:MI:SS') Last_Free_Date" ).append("\n"); 
		query.append("              ,nvl(US_CGO_RLSE.FRT_CLT_FLG,'N') f                                                                                       " ).append("\n"); 
		query.append("              ,nvl(US_CGO_RLSE.OBL_RDEM_FLG,'N') o                                                                                   " ).append("\n"); 
		query.append("              -- POD : 'CA',DEL : 'US'의 경우 Rail AMS 정보를 보여준다.                                                                                " ).append("\n"); 
		query.append("              -- POD : 'CA',DEL : 'US'의 경우 Rail AMS 정보를 보여준다.                                                                                " ).append("\n"); 
		query.append("              ,nvl(CASE WHEN (substr(BKG.pod_cd,0,2) = 'CA') and  (substr(BKG.del_cd,0,2) = 'US') THEN" ).append("\n"); 
		query.append("            		  (" ).append("\n"); 
		query.append("            		   select /*+ index_desc(x XPKBKG_CSTMS_ADV_CNTR_RSLT) */" ).append("\n"); 
		query.append("            		          x.cstms_clr_cd" ).append("\n"); 
		query.append("            		     from bkg_cstms_adv_cntr_rslt x" ).append("\n"); 
		query.append("            		    where x.cnt_cd = 'US'  --상수값" ).append("\n"); 
		query.append("                          and x.bl_no = SO.bl_no" ).append("\n"); 
		query.append("            			  and (substr(x.cntr_no,0,length(x.cntr_no)-1) = substr(SO.eq_no,0,length(SO.eq_no)-1) OR x.cntr_no = substr(SO.eq_no,0,length(SO.eq_no)-1))" ).append("\n"); 
		query.append("            			  and rownum < 2" ).append("\n"); 
		query.append("            		   )" ).append("\n"); 
		query.append("            	   ELSE US_CGO_RLSE.CSTMS_CLR_CD" ).append("\n"); 
		query.append("            	   END,'N' ) as c" ).append("\n"); 
		query.append("              ,SO.CSTMS_CLR_NO AS CS_Clear_NO" ).append("\n"); 
		query.append("              ,TO_CHAR(SO.N1ST_NOD_PLN_DT" ).append("\n"); 
		query.append("              ,'YYYY-MM-DD HH24:MI') AS Expected_Departure_Time" ).append("\n"); 
		query.append("              ,TO_CHAR(SO.LST_NOD_PLN_DT,'YYYY-MM-DD HH24:MI') AS Expected_Arrival_Time" ).append("\n"); 
		query.append("              ,TO_CHAR(SO.DOR_NOD_PLN_DT,'YYYY-MM-DD HH24:MI') AS Door_Arrival_Appointment_Time" ).append("\n"); 
		query.append("              ,SO.LST_LOC_CD AS USA_Last_City" ).append("\n"); 
		query.append("--            ,TRS_GET_BLCK_STWG_CD_FNC(so.bkg_no) AS BLCK_STWG" ).append("\n"); 
		query.append("              ,BKG.BLCK_STWG_CD AS BLCK_STWG" ).append("\n"); 
		query.append("              ,LOC3.LOC_NM||'('||SO.DEL_CD||')' AS DEL_CD" ).append("\n"); 
		query.append("              ,SO.SPCL_INSTR_RMK AS Remark" ).append("\n"); 
		query.append("              ,(select CNTR_SEAL_NO from BKG_CNTR_SEAL_NO where bkg_no = so.bkg_no and cntr_no = so.eq_no and CNTR_SEAL_SEQ = 1) Seal_No_1" ).append("\n"); 
		query.append("              ,(select CNTR_SEAL_NO from BKG_CNTR_SEAL_NO where bkg_no = so.bkg_no and cntr_no = so.eq_no and CNTR_SEAL_SEQ = 2) Seal_No_2" ).append("\n"); 
		query.append("              ,DECODE(WO.DTN_USE_FLG, 'Y','Detain', '') AS Detain" ).append("\n"); 
		query.append("              ,DECODE(WO.PRE_DIS_USE_FLG, 'Y','Pre-Dispatched','') AS Predispatch" ).append("\n"); 
		query.append("              ,SO.MLT_STOP_DE_FLG AS MLT_STOP_DE_FLG" ).append("\n"); 
		query.append("              ,DECODE(WO.WO_BL_NO_ISS_FLG, 'Y','B-No Issue', '') AS Bnum" ).append("\n"); 
		query.append("              ,SO.BKG_NO AS BKG_NO" ).append("\n"); 
		query.append("			  ,SO.TRO_LOD_REF_NO" ).append("\n"); 
		query.append("			  ,DECODE(SO.TRSP_COST_DTL_MOD_CD,'ER',NULL,'LS',NULL,'TS',NULL,'CF',NULL,'CN',NULL,DECODE(SO.TRSP_CRR_MOD_CD,'TD',DECODE(SO.TRSP_BND_CD,'O',TO_CHAR(COP.RAIL_RCV_COFF_FM_DT,'YYYY-MM-DD HH24:MI'),NULL),NULL)) AS Rail_Receiving_Date_FM" ).append("\n"); 
		query.append("              ,DECODE(SO.TRSP_COST_DTL_MOD_CD,'ER',NULL,'LS',NULL,'TS',NULL,'CF',NULL,'CN',NULL,DECODE(SO.TRSP_CRR_MOD_CD,'TD',DECODE(SO.TRSP_BND_CD,'O',TO_CHAR(COP.RAIL_RCV_COFF_TO_DT,'YYYY-MM-DD HH24:MI'),NULL),NULL)) AS Rail_Receiving_Date_TO" ).append("\n"); 
		query.append("              ,SO.TRO_SEQ AS TRO_SEQ" ).append("\n"); 
		query.append("--			  ,(SELECT COUNT(MVMT_STS_CD)" ).append("\n"); 
		query.append("--        		  FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("--        	     WHERE 1=1" ).append("\n"); 
		query.append("--          		   AND CNTR_NO = SO.EQ_NO" ).append("\n"); 
		query.append("--          		   AND BKG_NO = SO.BKG_NO" ).append("\n"); 
		query.append("--          		   AND MVMT_STS_CD = 'ID') CTMSTS_ID_CNT" ).append("\n"); 
		query.append("              ,ROWNUM AS CNTR_SEQ" ).append("\n"); 
		query.append("        FROM   TRS_TRSP_WRK_ORD                          WO" ).append("\n"); 
		query.append("              ,TRS_TRSP_SVC_ORD                          SO" ).append("\n"); 
		query.append("              ,MDM_COMMODITY                             CMDT" ).append("\n"); 
		query.append("              ,BKG_CGO_RLSE                              US_CGO_RLSE" ).append("\n"); 
		query.append("              ,BKG_CONTAINER                             BKG_CNTR" ).append("\n"); 
		query.append("              ,BKG_CUSTOMER                              BKG_CUST" ).append("\n"); 
		query.append("              ,MDM_CUSTOMER                              CUST" ).append("\n"); 
		query.append("              ,MDM_CUST_CNTC_PNT                         CUST_CNTC" ).append("\n"); 
		query.append("              ,MDM_CNTR_TP_SZ                            TPSZ" ).append("\n"); 
		query.append("              ,MDM_VSL_CNTR                              VSL" ).append("\n"); 
		query.append("              ,MDM_LOCATION                              LOC" ).append("\n"); 
		query.append("              ,MDM_LOCATION                              LOC1" ).append("\n"); 
		query.append("              ,MDM_LOCATION                              LOC2" ).append("\n"); 
		query.append("              ,MDM_LOCATION                              LOC3" ).append("\n"); 
		query.append("              ,BKG_BOOKING			                     BKG" ).append("\n"); 
		query.append("              ,SCE_COP_HDR                               COP" ).append("\n"); 
		query.append("	   	      ,BKG_PKUP_NTC_PKUP_NO                      pu" ).append("\n"); 
		query.append("       WHERE   WO.TRSP_WO_OFC_CTY_CD = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("         AND   WO.TRSP_WO_SEQ = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("         AND   SO.COP_NO = COP.COP_NO(+)" ).append("\n"); 
		query.append("    #if ($wo_no.size() > 0) " ).append("\n"); 
		query.append("         AND (wo.trsp_wo_ofc_cty_cd,wo.trsp_wo_seq) in (" ).append("\n"); 
		query.append("    	#foreach($wonoKey in ${wo_no})" ).append("\n"); 
		query.append("    		#if($velocityCount < $wo_no.size()) " ).append("\n"); 
		query.append("    			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))," ).append("\n"); 
		query.append("    		#else " ).append("\n"); 
		query.append("    			(substr('$wonoKey',0,3),to_number(substr('$wonoKey',4,length('$wonoKey'))))" ).append("\n"); 
		query.append("    		#end " ).append("\n"); 
		query.append("    	#end " ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("    #else " ).append("\n"); 
		query.append("    	 AND 1=2 " ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append("    	 AND wo.wo_vndr_seq = @[wo_vndr_seq]" ).append("\n"); 
		query.append("    #if (${trsp_so_cmb_srt_no} != '')" ).append("\n"); 
		query.append("         AND wo.TRSP_SO_CMB_SRT_NO like @[trsp_so_cmb_srt_no]" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("         AND SO.CMDT_CD                          = CMDT.CMDT_CD(+)" ).append("\n"); 
		query.append("         AND SO.BKG_NO                           = BKG_CNTR.BKG_NO(+)" ).append("\n"); 
		query.append("         AND SO.EQ_NO                            = BKG_CNTR.CNTR_NO(+)" ).append("\n"); 
		query.append("         AND SO.BKG_NO                           = BKG.BKG_NO(+)" ).append("\n"); 
		query.append("         AND BKG.BL_NO                           = US_CGO_RLSE.BL_NO(+)" ).append("\n"); 
		query.append("         AND SO.BKG_NO                           = BKG_CUST.BKG_NO(+)" ).append("\n"); 
		query.append("         AND BKG_CUST.BKG_CUST_TP_CD(+)          = DECODE(SO.TRSP_BND_CD,'I','C','S')" ).append("\n"); 
		query.append("         AND BKG_CUST.CUST_CNT_CD                = CUST.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("         AND BKG_CUST.CUST_SEQ                   = CUST.CUST_SEQ(+)" ).append("\n"); 
		query.append("         AND CUST.CUST_CNT_CD                    = CUST_CNTC.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("         AND CUST.CUST_SEQ                       = CUST_CNTC.CUST_SEQ(+)" ).append("\n"); 
		query.append("         AND CUST_CNTC.CUST_CNTC_PNT_SEQ(+)      = 1" ).append("\n"); 
		query.append("         AND SO.TRSP_NXT_PORT_CD                 = LOC1.LOC_CD (+)" ).append("\n"); 
		query.append("         AND SO.POD_CD                           = LOC2.LOC_CD (+)" ).append("\n"); 
		query.append("         AND SO.DEL_CD                           = LOC3.LOC_CD (+)" ).append("\n"); 
		query.append("         AND SO.VSL_CD                           = VSL.VSL_CD (+)" ).append("\n"); 
		query.append("         AND SO.EQ_TPSZ_CD                       = TPSZ.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("	     AND so.eq_no                            = pu.cntr_no(+)" ).append("\n"); 
		query.append("	     AND so.bkg_no                           = pu.bkg_no(+)" ).append("\n"); 
		query.append("	     AND pu.del_cd                           = LOC.loc_cd(+)" ).append("\n"); 
		query.append("--         AND pu.ofc_cd                           = LOC.eq_ctrl_ofc_cd(+)" ).append("\n"); 
		query.append("		 AND NVL(TO_DATE(pu.upd_dt, 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('11111111 111111', 'YYYY-MM-DD HH24:MI:SS')) = NVL((" ).append("\n"); 
		query.append("            SELECT TO_DATE(MAX(Y.UPD_DT), 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("            FROM BKG_PKUP_NTC_PKUP_NO Y" ).append("\n"); 
		query.append("            WHERE Y.BKG_NO = pu.BKG_NO" ).append("\n"); 
		query.append("              AND Y.CNTR_NO = pu.CNTR_NO" ).append("\n"); 
		query.append("              AND Y.PKUP_YD_CD = pu.PKUP_YD_CD), TO_DATE('11111111 111111', 'YYYY-MM-DD HH24:MI:SS'))" ).append("\n"); 
		query.append("      ) CNTR" ).append("\n"); 
		query.append("     ,BKG_EUR_TRO_DTL multi" ).append("\n"); 
		query.append("WHERE CNTR.BKG_NO = MULTI.BKG_NO(+)" ).append("\n"); 
		query.append("  AND CNTR.TRO_SEQ = MULTI.TRO_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY  CNTR_SEQ" ).append("\n"); 
		query.append("         ,Equipment_Number" ).append("\n"); 
		query.append("         ,Type_Size" ).append("\n"); 
		query.append("         ,Rate" ).append("\n"); 
		query.append("         ,Special_Cargo" ).append("\n"); 
		query.append("         ,Weight" ).append("\n"); 
		query.append("         ,Commodity_Description" ).append("\n"); 
		query.append("         ,Inbond_Transit_Number" ).append("\n"); 
		query.append("         ,Purchase_Order_No" ).append("\n"); 
		query.append("         ,Booking_Number" ).append("\n"); 
		query.append("         ,BL_NO" ).append("\n"); 
		query.append("         ,Vessel" ).append("\n"); 
		query.append("         ,next_port" ).append("\n"); 
		query.append("         ,Shipper_Name" ).append("\n"); 
		query.append("         ,Shipper_Telephone_Number" ).append("\n"); 
		query.append("         ,Door_Service_Type" ).append("\n"); 
		query.append("         ,Pickup_No" ).append("\n"); 
		query.append("         ,Available_Date" ).append("\n"); 
		query.append("         ,Last_Free_Date" ).append("\n"); 
		query.append("         ,f" ).append("\n"); 
		query.append("         ,o" ).append("\n"); 
		query.append("         ,c" ).append("\n"); 
		query.append("         ,CS_Clear_NO" ).append("\n"); 
		query.append("         ,Expected_Departure_Time" ).append("\n"); 
		query.append("         ,Expected_Arrival_Time" ).append("\n"); 
		query.append("         ,Door_Arrival_Appointment_Time" ).append("\n"); 
		query.append("         ,USA_Last_City" ).append("\n"); 
		query.append("         ,BLCK_STWG" ).append("\n"); 
		query.append("         ,DEL_CD" ).append("\n"); 
		query.append("         ,Remark" ).append("\n"); 
		query.append("         ,Predispatch" ).append("\n"); 
		query.append("         ,Seal_No_1" ).append("\n"); 
		query.append("		 ,Seal_No_2" ).append("\n"); 
		query.append("         ,Detain" ).append("\n"); 
		query.append("         ,MLT_STOP_DE_FLG" ).append("\n"); 
		query.append("         ,Bnum" ).append("\n"); 
		query.append("         ,CNTR.bkg_no" ).append("\n"); 
		query.append("         ,TRO_LOD_REF_NO" ).append("\n"); 
		query.append("		 ,Rail_Receiving_Date_FM" ).append("\n"); 
		query.append("		 ,Rail_Receiving_Date_TO" ).append("\n"); 
		query.append("--		 ,CTMSTS_ID_CNT" ).append("\n"); 
		query.append("ORDER BY CNTR_SEQ asc" ).append("\n"); 

	}
}