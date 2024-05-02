/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi322ReceiveDBDAOAddEdi322MsgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.18
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.08.18 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.receiveeai.edi322receive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi322ReceiveDBDAOAddEdi322MsgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AddEdi322Msg
	  * </pre>
	  */
	public Edi322ReceiveDBDAOAddEdi322MsgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CN_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EVENT_YARD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EVNT_CTY_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VVD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EVENT_STS",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VSL_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TI_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PICKUP_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("LLOYD_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EVENT_DT",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("PSN_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DEST_LOC",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BL_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VSL_VOY_DIR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EP_REPOSITION",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("RCVR_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EVNT_STE_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("SPCL_HNDL_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("BKG_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DEST_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EQ_DESC_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WO_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TRANS_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("FLAT_CAR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("EQ_STS_CD",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("WAY_BILL_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CARRIER_COUNTRY",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CNTR_NO",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("MT_PLAN",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("CHSS_CODE",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("VSL_NM",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("DEST_STS",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("TMNL_ID",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("RAIL_DEST_N1ST_ETA_DT",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.receiveeai.edi322receive.integration").append("\n"); 
		query.append("FileName : Edi322ReceiveDBDAOAddEdi322MsgUSQL").append("\n"); 
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
		query.append("MERGE INTO EDI_322_MSG D	                                 " ).append("\n"); 
		query.append("		     USING ( SELECT TO_DATE(@[EVENT_DT], 'yyyy/mm/dd HH24:MI:SS') iEVNT_DT, @[CNTR_NO] iEQ_NO,@[EVENT_STS]  iEDI_322_STS_CD, " ).append("\n"); 
		query.append("		 		             @[TMNL_ID] iSNDR_ID, @[RCVR_ID] iRCVR_ID, @[EVENT_YARD] iEVNT_YD_CD, " ).append("\n"); 
		query.append("		 		             @[EVNT_CTY_NM] iEVNT_CTY_NM, @[EVNT_STE_CD] iEVNT_STE_CD, @[CARRIER_COUNTRY] iEVNT_CNT_CD,  " ).append("\n"); 
		query.append("		 		             @[EQ_DESC_CD] iEQ_DESC_CD, DECODE(@[EQ_STS_CD],'F','L','M','E',@[EQ_STS_CD]) iEQ_STS_CD, @[CHSS_CODE] iCHSS_EDI_322_NO, " ).append("\n"); 
		query.append("		 		             @[VSL_CD] iVSL_CD, @[LLOYD_NO] iLLOYD_VSL_NO, @[VSL_NM] iVSL_NM, @[VSL_VOY_DIR_NO] iVSL_VOY_DIR_NO, " ).append("\n"); 
		query.append("		 		             @[SPCL_HNDL_CD] iSPCL_HNDL_CD, @[BL_NO] iBL_EDI_322_NO, " ).append("\n"); 
		query.append("                             (REPLACE(REPLACE (REPLACE (@[BKG_NO], '&amp;', '&'), '&lt;', '<'),'&amp;&lt;&#xD;&#xA;&gt;&apos;&quot;','\n')) AS iBKG_EDI_322_NO," ).append("\n"); 
		query.append("		 		             sysdate iCRE_DT,sysdate iUPD_DT, @[PSN_CD] iPSN_CD, @[PICKUP_NO] iPKUP_EDI_322_NO, TO_DATE(@[RAIL_DEST_N1ST_ETA_DT], 'yyyy/mm/dd HH24:MI:SS') iRAIL_DEST_N1ST_ETA_DT," ).append("\n"); 
		query.append("                             @[VVD] iEDI_VVD_CD, @[TI_NO] iTIR_NO, @[MT_PLAN] iMTY_PLN_NO, @[WO_NO] iWO_NO," ).append("\n"); 
		query.append("                             @[EP_REPOSITION] iMTY_REPO_NO, @[CN_NO] iEDI_CRR_NO, @[TRANS_NO] iTRSP_DOC_NO, " ).append("\n"); 
		query.append("                             @[DEST_LOC] iDEST_LOC_NM, @[DEST_NM] iDEST_CTY_NM, @[DEST_STS] iDEST_STE_NM, @[FLAT_CAR_NO] iFCAR_NO, @[WAY_BILL_NO] iWBL_NO" ).append("\n"); 
		query.append("                             FROM DUAL ) S " ).append("\n"); 
		query.append("		     ON  (D.EVNT_DT = S.iEVNT_DT AND D.EQ_NO   = S.iEQ_NO AND D.EDI_322_STS_CD = S.iEDI_322_STS_CD) " ).append("\n"); 
		query.append("		    WHEN MATCHED THEN  " ).append("\n"); 
		query.append("		         UPDATE SET D.SNDR_ID            = S.iSNDR_ID,            " ).append("\n"); 
		query.append("		                    D.RCVR_ID		      = S.iRCVR_ID,            " ).append("\n"); 
		query.append("		                    D.EVNT_YD_CD	      = S.iEVNT_YD_CD,         " ).append("\n"); 
		query.append("		                    D.EVNT_CTY_NM	      = S.iEVNT_CTY_NM,        " ).append("\n"); 
		query.append("		                    D.EVNT_STE_CD	      = S.iEVNT_STE_CD,        " ).append("\n"); 
		query.append("		                    D.EVNT_CNT_CD	      = S.iEVNT_CNT_CD,        " ).append("\n"); 
		query.append("		                    D.EQ_DESC_CD	      = S.iEQ_DESC_CD,         " ).append("\n"); 
		query.append("		                    D.EQ_STS_CD          = S.iEQ_STS_CD,          " ).append("\n"); 
		query.append("		                    D.CHSS_EDI_322_NO    = S.iCHSS_EDI_322_NO,    " ).append("\n"); 
		query.append("		                    D.VSL_CD		      = S.iVSL_CD,             " ).append("\n"); 
		query.append("		                    D.LLOYD_VSL_NO	      = S.iLLOYD_VSL_NO,       " ).append("\n"); 
		query.append("		                    D.VSL_NM		      = S.iVSL_NM,             " ).append("\n"); 
		query.append("		                    D.VSL_VOY_DIR_NO     = S.iVSL_VOY_DIR_NO,     " ).append("\n"); 
		query.append("		                    D.SPCL_HNDL_CD	      = S.iSPCL_HNDL_CD,       " ).append("\n"); 
		query.append("		                    D.BL_EDI_322_NO	  = S.iBL_EDI_322_NO,      " ).append("\n"); 
		query.append("		                    D.BKG_EDI_322_NO     = S.iBKG_EDI_322_NO,     " ).append("\n"); 
		query.append("		                    D.UPD_DT		      = S.iUPD_DT," ).append("\n"); 
		query.append("		                    D.UPD_USR_ID          = S.iSNDR_ID,             " ).append("\n"); 
		query.append("		                    D.PSN_CD		      = S.iPSN_CD,             " ).append("\n"); 
		query.append("		                    D.PKUP_EDI_322_NO    = S.iPKUP_EDI_322_NO,     " ).append("\n"); 
		query.append("		                    D.RAIL_DEST_N1ST_ETA_DT   = S.iRAIL_DEST_N1ST_ETA_DT ," ).append("\n"); 
		query.append("                            D.EDI_VVD_CD         = S.iEDI_VVD_CD," ).append("\n"); 
		query.append("                            D.TIR_NO             = S.iTIR_NO," ).append("\n"); 
		query.append("                            D.MTY_PLN_NO         = S.iMTY_PLN_NO," ).append("\n"); 
		query.append("                            D.MTY_REPO_NO        = S.iMTY_REPO_NO," ).append("\n"); 
		query.append("                            D.EDI_CRR_NO         = S.iEDI_CRR_NO," ).append("\n"); 
		query.append("                            D.TRSP_DOC_NO        = S.iTRSP_DOC_NO," ).append("\n"); 
		query.append("                            D.WO_NO              = S.iWO_NO," ).append("\n"); 
		query.append("                            D.DEST_LOC_NM        = S.iDEST_LOC_NM, " ).append("\n"); 
		query.append("                            D.DEST_CTY_NM        = S.iDEST_CTY_NM, " ).append("\n"); 
		query.append("                            D.DEST_STE_NM        = S.iDEST_STE_NM, " ).append("\n"); 
		query.append("                            D.FCAR_NO            = S.iFCAR_NO, " ).append("\n"); 
		query.append("                            D.WBL_NO             = S.iWBL_NO " ).append("\n"); 
		query.append("		    WHEN NOT MATCHED THEN INSERT (D.EVNT_DT, D.EQ_NO, D.EDI_322_STS_CD,                 " ).append("\n"); 
		query.append("		                                  D.SNDR_ID, D.RCVR_ID, D.EVNT_YD_CD,                   " ).append("\n"); 
		query.append("		                                  D.EVNT_CTY_NM, D.EVNT_STE_CD, D.EVNT_CNT_CD,          " ).append("\n"); 
		query.append("		                                  D.EQ_DESC_CD, D.EQ_STS_CD, D.CHSS_EDI_322_NO,         " ).append("\n"); 
		query.append("		                                  D.VSL_CD, D.LLOYD_VSL_NO, D.VSL_NM, D.VSL_VOY_DIR_NO, " ).append("\n"); 
		query.append("		                                  D.SPCL_HNDL_CD, D.BL_EDI_322_NO, D.BKG_EDI_322_NO,    " ).append("\n"); 
		query.append("		                                  D.CRE_DT, D.PSN_CD, D.PKUP_EDI_322_NO,                " ).append("\n"); 
		query.append("		                                  D.RAIL_DEST_N1ST_ETA_DT, D.UPD_DT, D.CRE_USR_ID, D.UPD_USR_ID," ).append("\n"); 
		query.append("                                          D.EDI_VVD_CD, D.TIR_NO,D.MTY_PLN_NO,D.MTY_REPO_NO,D.EDI_CRR_NO,D.TRSP_DOC_NO,D.WO_NO," ).append("\n"); 
		query.append("                                          D.DEST_LOC_NM, D.DEST_CTY_NM, D.DEST_STE_NM, D.FCAR_NO, D.WBL_NO )                              " ).append("\n"); 
		query.append("		         VALUES  (S.iEVNT_DT, S.iEQ_NO, S.iEDI_322_STS_CD,                              " ).append("\n"); 
		query.append("		                  S.iSNDR_ID, S.iRCVR_ID, S.iEVNT_YD_CD,                                " ).append("\n"); 
		query.append("		                  S.iEVNT_CTY_NM, S.iEVNT_STE_CD, S.iEVNT_CNT_CD,                       " ).append("\n"); 
		query.append("		                  S.iEQ_DESC_CD, S.iEQ_STS_CD, S.iCHSS_EDI_322_NO,                      " ).append("\n"); 
		query.append("		                  S.iVSL_CD, S.iLLOYD_VSL_NO, S.iVSL_NM, S.iVSL_VOY_DIR_NO,             " ).append("\n"); 
		query.append("		                  S.iSPCL_HNDL_CD, S.iBL_EDI_322_NO, S.iBKG_EDI_322_NO,                 " ).append("\n"); 
		query.append("		                  S.iCRE_DT, S.iPSN_CD, S.iPKUP_EDI_322_NO,                              " ).append("\n"); 
		query.append("		                  S.iRAIL_DEST_N1ST_ETA_DT, S.iUPD_DT, S.iSNDR_ID, S.iSNDR_ID," ).append("\n"); 
		query.append("                          S.iEDI_VVD_CD, S.iTIR_NO, S.iMTY_PLN_NO, S.iMTY_REPO_NO, S.iEDI_CRR_NO, S.iTRSP_DOC_NO, S.iWO_NO," ).append("\n"); 
		query.append("                          S.iDEST_LOC_NM, S.iDEST_CTY_NM, S.iDEST_STE_NM, S.iFCAR_NO, S.iWBL_NO)" ).append("\n"); 

	}
}