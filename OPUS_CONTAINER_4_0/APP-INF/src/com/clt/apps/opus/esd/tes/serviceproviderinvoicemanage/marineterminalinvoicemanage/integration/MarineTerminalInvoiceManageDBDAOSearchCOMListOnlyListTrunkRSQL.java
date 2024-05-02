/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListTrunkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListTrunkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOMListOnlyListTrunk
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListTrunkRSQL(){
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
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ts_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListTrunkRSQL").append("\n"); 
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
		query.append("WITH CNTRLIST AS" ).append("\n"); 
		query.append("(SELECT C1.*, " ).append("\n"); 
		query.append("            CASE WHEN C1.R_BG_YD_FLG = 'Y' AND C1.R_ORG_NOD_TP_CD = 'B' AND NVL(C1.R_TRSP_MOD_CD,'N')||NVL(C1.O_TRSP_MOD_CD,'N') = 'WDVD'" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("                 WHEN C1.O_BG_YD_FLG = 'Y' AND C1.O_DEST_NOD_TP_CD = 'B' AND NVL(C1.R_TRSP_MOD_CD,'N')||NVL(C1.O_TRSP_MOD_CD,'N') = 'VDWD'" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("                 WHEN C1.R_BG_YD_FLG = 'Y' AND C1.R_ORG_NOD_TP_CD = 'M' AND NVL(C1.R_TRSP_MOD_CD,'N')||NVL(C1.O_TRSP_MOD_CD,'N') = 'WDVD'" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("                 WHEN C1.O_BG_YD_FLG = 'Y' AND C1.O_DEST_NOD_TP_CD = 'M' AND NVL(C1.R_TRSP_MOD_CD,'N')||NVL(C1.O_TRSP_MOD_CD,'N') = 'VDWD'" ).append("\n"); 
		query.append("                 THEN 'T'" ).append("\n"); 
		query.append("                 ELSE C1.LOCL_TS_IND_CD1" ).append("\n"); 
		query.append("                 END LOCL_TS_IND_CD," ).append("\n"); 
		query.append("            CASE WHEN C1.R_BG_YD_FLG = 'Y' AND C1.R_ORG_NOD_TP_CD = 'B' AND NVL(C1.R_TRSP_MOD_CD,'N')||NVL(C1.O_TRSP_MOD_CD,'N') = 'WDVD'" ).append("\n"); 
		query.append("                 THEN 'B'" ).append("\n"); 
		query.append("                 WHEN C1.O_BG_YD_FLG = 'Y' AND C1.O_DEST_NOD_TP_CD = 'B' AND NVL(C1.R_TRSP_MOD_CD,'N')||NVL(C1.O_TRSP_MOD_CD,'N') = 'VDWD'" ).append("\n"); 
		query.append("                 THEN 'B'" ).append("\n"); 
		query.append("                 WHEN C1.R_BG_YD_FLG = 'Y' AND C1.R_ORG_NOD_TP_CD = 'M' AND NVL(C1.R_TRSP_MOD_CD,'N')||NVL(C1.O_TRSP_MOD_CD,'N') = 'WDVD'" ).append("\n"); 
		query.append("                 THEN 'B'" ).append("\n"); 
		query.append("                 WHEN C1.O_BG_YD_FLG = 'Y' AND C1.O_DEST_NOD_TP_CD = 'M' AND NVL(C1.R_TRSP_MOD_CD,'N')||NVL(C1.O_TRSP_MOD_CD,'N') = 'VDWD'" ).append("\n"); 
		query.append("                 THEN 'B'" ).append("\n"); 
		query.append("                 ELSE C1.TML_TRNS_MOD_CD1" ).append("\n"); 
		query.append("                 END TML_TRNS_MOD_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append(" (" ).append("\n"); 
		query.append("	 SELECT DISTINCT L.CNTR_NO        							   CNTR_NO," ).append("\n"); 
		query.append("			L.TPSZ                                                 CNTR_TPSZ_CD," ).append("\n"); 
		query.append("			L.FM                                                   CNTR_STY_CD," ).append("\n"); 
		query.append("			L.IPC                                                  IOC_CD," ).append("\n"); 
		query.append("			L.LANE                                                 LANE_CD," ).append("\n"); 
		query.append("			L.LANE                                                 LANE_CD2," ).append("\n"); 
		query.append("		    L.SUB_TRD_CD										   SUB_TRD_CD," ).append("\n"); 
		query.append("            DECODE(L.PCTL_IO_BND_CD,'T','T','L') LOCL_TS_IND_CD1, --T/S determination should be based solely on COP (20160510.xinyi)" ).append("\n"); 
		query.append("            (SELECT 'Y'" ).append("\n"); 
		query.append("               FROM PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("              WHERE PCTL_NO     = R.PCTL_NO" ).append("\n"); 
		query.append("                AND N1ST_NOD_CD = DECODE(@[io_bnd_cd],'O',R.ORG_NOD_CD,R.DEST_NOD_CD)" ).append("\n"); 
		query.append("                AND COST_ACT_GRP_CD IN ('NIBB','NIBY','NOBB','NOBY')" ).append("\n"); 
		query.append("                AND ROWNUM = 1) R_BG_YD_FLG, --Barge T/S 로직 수정 관련 추가 2016.12.23" ).append("\n"); 
		query.append("             (SELECT 'Y'" ).append("\n"); 
		query.append("                FROM PRD_PROD_CTL_ACT_GRP_DTL" ).append("\n"); 
		query.append("               WHERE PCTL_NO = O.PCTL_NO" ).append("\n"); 
		query.append("                 AND N1ST_NOD_CD = DECODE(@[io_bnd_cd],'O',O.ORG_NOD_CD,O.DEST_NOD_CD)" ).append("\n"); 
		query.append("                 AND COST_ACT_GRP_CD IN ('NIBB','NIBY','NOBB','NOBY')" ).append("\n"); 
		query.append("                 AND ROWNUM = 1) O_BG_YD_FLG," ).append("\n"); 
		query.append("            L.RCVDE_TERM_IND_CD                                    RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("			L.BKG_NO                                               BKG_NO," ).append("\n"); 
		query.append("			NVL(DECODE(L.FM,'M',DECODE(SUBSTR(@[yd_cd],1,5),L.POL,'O','I')," ).append("\n"); 
		query.append("					DECODE(NVL(R.TRSP_MOD_CD,'N')||NVL(O.TRSP_MOD_CD,'N'),'WDTD','I','WDRD','I','VDTD','I','VDRD','I','RDWD','O','RDVD','O','TDWD','O','TDVD','O'," ).append("\n"); 
		query.append("													   'WDN','I','VDN','I','NVD','O','NWD','O'," ).append("\n"); 
		query.append("													   'WDVD',DECODE(@[vvd],R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("													   'VDWD',DECODE(@[vvd],R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("													   'WDWD',DECODE(@[vvd],R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O')," ).append("\n"); 
		query.append("													   'VDVD',DECODE(@[vvd],R.VSL_CD||R.SKD_VOY_NO||R.SKD_DIR_CD,'I','O'))),LOWER(@[io_bnd_cd])) IO_BND_CD," ).append("\n"); 
		query.append("			 NVL(L.DCGO_CLSS_CD,'N')	DCGO_CLSS_CD," ).append("\n"); 
		query.append("			 NVL(L.BB_CGO_FLG,'N')		BB_CGO_FLG," ).append("\n"); 
		query.append("			 NVL(L.AWK_CGO_FLG,'N')		AWK_CGO_FLG," ).append("\n"); 
		query.append("			 NVL(L.RC_FLG,'N')			RC_FLG," ).append("\n"); 
		query.append("			 L.CNTR_RMK	CNTR_RMK, R.TRSP_MOD_CD AS R_TRSP_MOD_CD, O.TRSP_MOD_CD AS O_TRSP_MOD_CD, R.ORG_NOD_TP_CD AS R_ORG_NOD_TP_CD, O.ORG_NOD_TP_CD AS O_ORG_NOD_TP_CD, R.DEST_NOD_TP_CD AS R_DEST_NOD_TP_CD, O.DEST_NOD_TP_CD AS O_DEST_NOD_TP_CD," ).append("\n"); 
		query.append("			 DECODE(DECODE(L.PCTL_IO_BND_CD,'T'," ).append("\n"); 
		query.append("                    DECODE(R.TRSP_MOD_CD||O.TRSP_MOD_CD,'WDVD','T','VDWD','T','WDWD','T','VDVD','T',DECODE(L.FM,'M',NULL,'R',NULL,'L')),'L'),'L'," ).append("\n"); 
		query.append("					DECODE(L.FM,'F',DECODE(@[io_bnd_cd],'O',DECODE(R.TRSP_MOD_CD,'TD','T','RD','R','WD','B','O')," ).append("\n"); 
		query.append("                                    DECODE(RL,0,DECODE(TR,'RD','R','WD','B','TD','T',DECODE(R.TRSP_MOD_CD,'RD','R','WD','B','T')),'R'))," ).append("\n"); 
		query.append("                                'M',DECODE(O.TRSP_MOD_CD,'TD','T','RD','R','WD','B','O')),VSL_TP) TML_TRNS_MOD_CD1,                   			 " ).append("\n"); 
		query.append("			 @[vvd]																			VVD," ).append("\n"); 
		query.append("			 SUBSTR(@[vvd],1,4)																VSL_CD," ).append("\n"); 
		query.append("			 SUBSTR(@[vvd],5,4)																SKD_VOY_NO," ).append("\n"); 
		query.append("			 SUBSTR(@[vvd],9,1)																SKD_DIR_CD," ).append("\n"); 
		query.append("			 @[atb_dt]																		ATB_DT," ).append("\n"); 
		query.append("			 @[vndr_seq]																	VNDR_SEQ," ).append("\n"); 
		query.append("			 ''																				DSCR_DTL_IND_CD," ).append("\n"); 
		query.append("			 ''																				WRK_DT," ).append("\n"); 
		query.append("			 ''																				BL_NO," ).append("\n"); 
		query.append("			 ''																				BL_NO_TP," ).append("\n"); 
		query.append("			 ''																				BL_NO_CHK," ).append("\n"); 
		query.append("			 'DC'																			VRFY_RSLT_IND_CD," ).append("\n"); 
		query.append("			 'Y'																			DC_FLG" ).append("\n"); 
		query.append("	 FROM ( SELECT B.CNTR_NO           CNTR_NO," ).append("\n"); 
		query.append("				   B.TPSZ              TPSZ," ).append("\n"); 
		query.append("				   B.FM                FM," ).append("\n"); 
		query.append("				   B.IPC               IPC," ).append("\n"); 
		query.append("				   B.LANE              LANE," ).append("\n"); 
		query.append("				   B.SUB_TRD_CD        SUB_TRD_CD," ).append("\n"); 
		query.append("				   B.RCVDE_TERM_IND_CD RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("				   MIN(B.BKG_NO)       BKG_NO," ).append("\n"); 
		query.append("				   MAX(G.PCTL_NO)      COP_NO," ).append("\n"); 
		query.append("				   MAX(B.TP_CD)        TP_CD," ).append("\n"); 
		query.append("				   MAX(B.POL)          POL," ).append("\n"); 
		query.append("				   MIN(B.DCGO_CLSS_CD) DCGO_CLSS_CD," ).append("\n"); 
		query.append("				   MIN(B.BB_CGO_FLG)   BB_CGO_FLG," ).append("\n"); 
		query.append("				   B.RM                CNTR_RMK," ).append("\n"); 
		query.append("				   MIN(B.AWK_CGO_FLG)  AWK_CGO_FLG," ).append("\n"); 
		query.append("				   MIN(B.RC_FLG)       RC_FLG," ).append("\n"); 
		query.append("				   B.VSL_TP            VSL_TP," ).append("\n"); 
		query.append("				   B.TR                TR," ).append("\n"); 
		query.append("				   B.RL                RL," ).append("\n"); 
		query.append("				   MIN(( SELECT MAX(PCTL_SEQ)" ).append("\n"); 
		query.append("    					 FROM   SCE_COP_HDR HD, PRD_PROD_CTL_ROUT_DTL GD" ).append("\n"); 
		query.append("    					 WHERE  H.CNTR_NO = HD.CNTR_NO" ).append("\n"); 
		query.append("    					 AND    H.PCTL_NO = HD.PCTL_NO" ).append("\n"); 
		query.append("    					 AND    B.BKG_NO  = HD.BKG_NO" ).append("\n"); 
		query.append("    					 AND    HD.PCTL_NO= GD.PCTL_NO" ).append("\n"); 
		query.append("    					 AND    GD.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("    					 AND    GD.PCTL_SEQ < G.PCTL_SEQ )) R_SEQ," ).append("\n"); 
		query.append("				   MAX(( SELECT MIN(PCTL_SEQ)" ).append("\n"); 
		query.append("					 FROM   SCE_COP_HDR OD, PRD_PROD_CTL_ROUT_DTL OG" ).append("\n"); 
		query.append("					 WHERE  OD.CNTR_NO = H.CNTR_NO" ).append("\n"); 
		query.append("					 AND    OD.PCTL_NO = H.PCTL_NO" ).append("\n"); 
		query.append("					 AND    OD.BKG_NO  = H.BKG_NO" ).append("\n"); 
		query.append("					 AND    OD.PCTL_NO = OG.PCTL_NO" ).append("\n"); 
		query.append("					 AND    OG.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("					 AND    OG.PCTL_SEQ > G.PCTL_SEQ )) O_SEQ," ).append("\n"); 
		query.append("                   G.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("	/** COM Only의 Bkg정보를 물고오는 부분에 단순 min/max말고 rank를 주어 Bkg_no/Bkg_no_split을 제대로 물고오게 변경한다.  **/" ).append("\n"); 
		query.append("			FROM   ( SELECT  X.CNTR_NO,X.SPLIT_FLG,X.TPSZ,X.BKG_RANK,X.FM,X.IPC,X.LANE,               " ).append("\n"); 
		query.append("			                CASE WHEN X.BR_SCONTI_CD = 'AE' AND X.BD_SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("    		     			     THEN 'EA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AF' AND X.BD_SCONTI_CD = 'AE'" ).append("\n"); 
		query.append("    						     THEN 'EA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AE' AND X.BD_SCONTI_CD = 'AE'" ).append("\n"); 
		query.append("    						     THEN 'EA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AF' AND X.BD_SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("    						     THEN 'EA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AE' AND X.BD_SCONTI_CD = 'AW'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AW' AND X.BD_SCONTI_CD = 'AE'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AF' AND X.BD_SCONTI_CD = 'AW'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AW' AND X.BD_SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AM' AND X.BD_SCONTI_CD = 'AW'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AW' AND X.BD_SCONTI_CD = 'AM'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AW' AND X.BD_SCONTI_CD = 'AW'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AM' AND X.BD_SCONTI_CD = 'AM'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AF' AND X.BD_SCONTI_CD = 'AM'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AM' AND X.BD_SCONTI_CD = 'AF'" ).append("\n"); 
		query.append("    						     THEN 'EA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AE' AND X.BD_SCONTI_CD = 'AM'" ).append("\n"); 
		query.append("    						     THEN 'WA'" ).append("\n"); 
		query.append("    						     WHEN X.BR_SCONTI_CD = 'AM' AND X.BD_SCONTI_CD = 'AE'" ).append("\n"); 
		query.append("    						     THEN 'EA'" ).append("\n"); 
		query.append("    						     ELSE X.SUB_TRD_CD --20161107 Sub Trade definition for 'IP' update within Asia.(xinyi요청)" ).append("\n"); 
		query.append("                    		  END SUB_TRD_CD,X.RCVDE_TERM_IND_CD,X.BKG_NO,X.POL,X.TP_CD,X.DCGO_CLSS_CD,X.BB_CGO_FLG,X.AWK_CGO_FLG,X.RC_FLG,X.RM,X.VSL_TP,X.TR,X.RL " ).append("\n"); 
		query.append("                        FROM ( SELECT C.CNTR_NO CNTR_NO, " ).append("\n"); 
		query.append("			                                  B.SPLIT_FLG," ).append("\n"); 
		query.append("                    						  C.CNTR_TPSZ_CD TPSZ," ).append("\n"); 
		query.append("                    						  DENSE_RANK() OVER (PARTITION BY C.CNTR_NO ORDER BY V.CRE_DT DESC, V.BKG_NO DESC) BKG_RANK," ).append("\n"); 
		query.append("                    						  DECODE(B.BKG_CGO_TP_CD,'F','F','B','F','R','R','M') FM," ).append("\n"); 
		query.append("                    						  DECODE(BR.CONTI_CD,BD.CONTI_CD,DECODE(BR.CNT_CD,BD.CNT_CD,'I','O'),'O') IPC, -- 20160218 IPC/OCN을 Domestic/International 개념으로 바꿈						" ).append("\n"); 
		query.append("                    						  V.SLAN_CD LANE,BR.SCONTI_CD BR_SCONTI_CD,BD.SCONTI_CD BD_SCONTI_CD," ).append("\n"); 
		query.append("                                              TES_SUB_TRD_CONV_FNC(@[vvd],V.SLAN_CD,V.POL_CD,V.POD_CD) SUB_TRD_CD, --20170111 sub_trd_cd function을 통해 구함                    						  " ).append("\n"); 
		query.append("                    						  B.RCV_TERM_CD||'/'||B.DE_TERM_CD RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("                    						  DECODE(B.BKG_STS_CD,'X',B.TO_BKG_NO,V.BKG_NO) BKG_NO, --20160518 Combine되서 cancel된 BKG과 해당 CNTR을 찾도록 로직 수정함(xinyi요청). 														" ).append("\n"); 
		query.append("                    						  B.POL_CD POL," ).append("\n"); 
		query.append("                    						  B.BKG_CGO_TP_CD TP_CD," ).append("\n"); 
		query.append("                    						  CASE WHEN D.CNTR_NO = C.CNTR_NO " ).append("\n"); 
		query.append("                    						       THEN NVL(SUBSTR(D.IMDG_CLSS_CD,1,1),'N') " ).append("\n"); 
		query.append("                    						       ELSE 'N' " ).append("\n"); 
		query.append("                    						  END DCGO_CLSS_CD, --DG가 아닌 CNTR에 대해서도 DG판정되어 수정함 (20160525, xinyi요청)" ).append("\n"); 
		query.append("                    						  NVL(C.BB_CGO_FLG,'N')	BB_CGO_FLG," ).append("\n"); 
		query.append("                    						  NVL(C.AWK_CGO_FLG,'N') AWK_CGO_FLG," ).append("\n"); 
		query.append("                    						  NVL(C.RC_FLG,'N') RC_FLG," ).append("\n"); 
		query.append("                    						  DECODE(NVL(C.BB_CGO_FLG,'N'),'Y','Break Bulk') RM," ).append("\n"); 
		query.append("                    						  DECODE(L.VSL_SVC_TP_CD,'O',DECODE((SELECT CRR_CD FROM MDM_VSL_CNTR  WHERE VSL_CD = S.VSL_CD),'NYK','V','F'),'V') VSL_TP," ).append("\n"); 
		query.append("                    						  ( SELECT MAX(TRSP_CRR_MOD_CD)" ).append("\n"); 
		query.append("                    							 FROM   TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("                    							 WHERE  ( FM_NOD_CD      = @[yd_cd] OR       TO_NOD_CD      = @[yd_cd] )" ).append("\n"); 
		query.append("                    							 AND    EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                    							 AND    NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                    							 AND    CRE_DT < TO_DATE(REPLACE(@[atb_dt],'-'),'YYYYMMDD') + 15 ) TR,    						   ( SELECT COUNT(*)" ).append("\n"); 
		query.append("                    							 FROM   TRS_TRSP_RAIL_BIL_ORD" ).append("\n"); 
		query.append("                    							 WHERE  ( FM_NOD_CD      = @[yd_cd] OR       TO_NOD_CD      = @[yd_cd] )" ).append("\n"); 
		query.append("                    							 AND    EQ_NO = C.CNTR_NO" ).append("\n"); 
		query.append("                    							 AND    NVL(DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("                    							 AND    CRE_DT < TO_DATE(REPLACE(@[atb_dt],'-'),'YYYYMMDD') + 15 AND ROWNUM = 1 ) RL    					 " ).append("\n"); 
		query.append("                    							 FROM   BKG_VVD V, BKG_CONTAINER C, BKG_BOOKING B, BKG_DG_CGO D, BKG_AWK_CGO A," ).append("\n"); 
		query.append("                    							 MDM_LOCATION BR, MDM_LOCATION BD,VSK_VSL_SKD S, MDM_VSL_SVC_LANE L" ).append("\n"); 
		query.append("                    					 WHERE  V.VSL_CD           = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                    					 AND    V.SKD_VOY_NO       = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                    					 AND    V.SKD_DIR_CD       = SUBSTR(@[vvd],9,1)                    					 					 " ).append("\n"); 
		query.append("                    					 AND    ( V.POL_YD_CD    = @[yd_cd]" ).append("\n"); 
		query.append("                    					 OR     V.POD_YD_CD      = @[yd_cd] )" ).append("\n"); 
		query.append("#if (${call_yd_ind_seq} == '1') --1.calling port ind seq와 vvd의 I/O를 인자값으로 같이 봐야하며, I일 경우 POD_CLPT_IND_SEQ, O일 경우 POL_CLPT_IND_SEQ를 조건으로 지정하도록 수정해야함" ).append("\n"); 
		query.append("                                --2.EQR function사용에 따른 재수정 : atb_dt를 사용하여 정확한 calling yd seq를 구해옴. 퍼포먼스 문제 생길 수 있음." ).append("\n"); 
		query.append("										 AND    EQR_GET_CLPT_SEQ_FNC(V.BKG_NO,@[yd_cd],@[atb_dt],@[vvd]) = '1'" ).append("\n"); 
		query.append("				                       --AND    (V.POL_CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("				                  	   --AND     V.POD_CLPT_IND_SEQ = '1')" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("										 AND    EQR_GET_CLPT_SEQ_FNC(V.BKG_NO,@[yd_cd],@[atb_dt],@[vvd]) <> '1'" ).append("\n"); 
		query.append("					                   --AND    (V.POL_CLPT_IND_SEQ <> '1'" ).append("\n"); 
		query.append("					                   --OR      V.POD_CLPT_IND_SEQ <> '1')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                    					 AND    V.BKG_NO           = C.BKG_NO(+)					 " ).append("\n"); 
		query.append("                    					 AND    C.BKG_NO           = B.BKG_NO(+)" ).append("\n"); 
		query.append("                    					 AND    (B.BKG_STS_CD IN ('F','W') OR (B.BKG_STS_CD = 'X' AND HCMT_CMB_FLG = 'Y'))  --20160518 Combine되서 cancel된 BKG과 해당 CNTR을 찾도록 로직 수정함(xinyi요청).					 " ).append("\n"); 
		query.append("                    					 AND    B.BKG_NO           = D.BKG_NO(+)                                         " ).append("\n"); 
		query.append("                    					 AND    C.BKG_NO           = A.BKG_NO(+)" ).append("\n"); 
		query.append("                    					 AND    C.CNTR_NO          = A.CNTR_NO(+)" ).append("\n"); 
		query.append("                    					 AND    B.POR_CD           = BR.LOC_CD" ).append("\n"); 
		query.append("                    					 AND    B.POD_CD           = BD.LOC_CD" ).append("\n"); 
		query.append("                    					 AND    V.VSL_CD           = S.VSL_CD(+)" ).append("\n"); 
		query.append("                    					 AND    V.SKD_VOY_NO       = S.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("                    					 AND    V.SKD_DIR_CD       = S.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("                    					 AND    S.VSL_SLAN_CD      = L.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("                    					 AND    L.DELT_FLG         = 'N' ) X, BKG_VVD V2" ).append("\n"); 
		query.append("                     WHERE  V2.BKG_NO     = X.BKG_NO -- cancel & combind bkg처리중 다른 vvd의 cntr이 포함되어 bkg_vvd기준으로 한번 더 쌈 2016.12.21 xinyi요청" ).append("\n"); 
		query.append("                     AND    V2.VSL_CD     = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("                     AND    V2.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("                     AND    V2.SKD_DIR_CD = SUBSTR(@[vvd],9,1)                    					 					 " ).append("\n"); 
		query.append("                     AND   (V2.POL_YD_CD  = @[yd_cd]" ).append("\n"); 
		query.append("                     OR     V2.POD_YD_CD  = @[yd_cd] ) " ).append("\n"); 
		query.append("                     AND DECODE(SPLIT_FLG,'Y',BKG_RANK,1) = 1 ) B, SCE_COP_HDR H, PRD_PROD_CTL_ROUT_DTL G" ).append("\n"); 
		query.append("			WHERE  B.CNTR_NO             = H.CNTR_NO(+)" ).append("\n"); 
		query.append("			AND    B.BKG_NO              = H.BKG_NO(+)" ).append("\n"); 
		query.append("			AND    NVL(H.COP_STS_CD,'N') <> 'X'" ).append("\n"); 
		query.append("			AND    H.PCTL_NO             = G.PCTL_NO(+)" ).append("\n"); 
		query.append("			AND    G.NOD_LNK_DIV_CD(+)   = 'N'" ).append("\n"); 
		query.append("			AND    G.ORG_NOD_CD(+)       = @[yd_cd] --vvd, sce, prd 에서 값을제대로 못가지고 와서 밑에 조건을 사용하였으나 아래의 사유로 다시 사용하는것으로 변경(2016.01.07)          			 " ).append("\n"); 
		query.append("			GROUP BY B.CNTR_NO,B.TPSZ,B.FM,B.IPC,B.LANE,B.RCVDE_TERM_IND_CD,B.RM,B.VSL_TP,B.TR,B.RL, G.PCTL_IO_BND_CD, B.SUB_TRD_CD" ).append("\n"); 
		query.append("			) L, PRD_PROD_CTL_ROUT_DTL R, PRD_PROD_CTL_ROUT_DTL O" ).append("\n"); 
		query.append("					  " ).append("\n"); 
		query.append("	 WHERE  L.COP_NO              = R.PCTL_NO(+)" ).append("\n"); 
		query.append("	 AND    R.NOD_LNK_DIV_CD(+)   = 'L'" ).append("\n"); 
		query.append("	 AND    L.R_SEQ               = R.PCTL_SEQ(+)" ).append("\n"); 
		query.append("	 AND    L.COP_NO              = O.PCTL_NO(+)" ).append("\n"); 
		query.append("	 AND    O.NOD_LNK_DIV_CD(+)   = 'L'" ).append("\n"); 
		query.append("	 AND    L.O_SEQ               = O.PCTL_SEQ(+)" ).append("\n"); 
		query.append("#if (${file_import_yn} == 'Y')" ).append("\n"); 
		query.append("		 AND L.CNTR_NO NOT IN (SELECT CNTR_NO" ).append("\n"); 
		query.append("							   FROM  TES_TML_SO_CNTR_LIST" ).append("\n"); 
		query.append("							   WHERE TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("							   AND   TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("							   AND   VSL_CD||SKD_VOY_NO||SKD_DIR_CD  = ( SELECT DISTINCT VVD_CD" ).append("\n"); 
		query.append("																		 FROM   TES_FILE_IMP_TMP" ).append("\n"); 
		query.append("																		 WHERE  TML_SO_OFC_CTY_CD  = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("																		 AND    TML_SO_SEQ         = @[tml_so_seq] ))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") C1)," ).append("\n"); 
		query.append("DB AS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT   BB.CNTR_NO, 'Double billing Inv : '||MAX(BB.INV_NO) CNTR_RMK" ).append("\n"); 
		query.append("    FROM" ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("        SELECT A.COST_CODE, C.CNTR_NO " ).append("\n"); 
		query.append("        FROM(" ).append("\n"); 
		query.append("            SELECT DISTINCT DECODE(1,0,C.LGS_COST_CD,DECODE(C.LGS_COST_CD,CD,TP,C.LGS_COST_CD)) COST_CODE" ).append("\n"); 
		query.append("            FROM ( SELECT COUNT(T.LGS_COST_CD) CNT," ).append("\n"); 
		query.append("                 T.LGS_COST_CD TP," ).append("\n"); 
		query.append("                 T.THRP_LGS_COST_CD CD," ).append("\n"); 
		query.append("                 H.TML_AGMT_OFC_CTY_CD CTY," ).append("\n"); 
		query.append("                 H.TML_AGMT_SEQ SEQ," ).append("\n"); 
		query.append("                 H.TML_AGMT_VER_NO NO" ).append("\n"); 
		query.append("                FROM   TES_TML_AGMT_HDR H, TES_TML_AGMT_THRP_COST T" ).append("\n"); 
		query.append("                WHERE  H.YD_CD            = @[yd_cd]" ).append("\n"); 
		query.append("                AND    H.VNDR_SEQ         = @[vndr_seq]" ).append("\n"); 
		query.append("                AND    H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("                AND    H.DELT_FLG        = 'N'" ).append("\n"); 
		query.append("                AND    TO_CHAR(H.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice" ).append("\n"); 
		query.append("                AND    TO_CHAR(H.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice " ).append("\n"); 
		query.append("                AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("                                             FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("                                             WHERE  M.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("                                             AND    M.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("                                             AND    M.TML_AGMT_STS_CD     = 'C'" ).append("\n"); 
		query.append("                                             AND    M.DELT_FLG            = 'N'" ).append("\n"); 
		query.append("                                             AND    TO_CHAR(M.EFF_FM_DT,'YYYYMMDD') <= REPLACE(@[atb_dt],'-') -- ATB Date([atb_dt]) ==> Marine Terminal Invoice                                         " ).append("\n"); 
		query.append("                                             AND    TO_CHAR(M.EFF_TO_DT,'YYYYMMDD') >= REPLACE(@[atb_dt],'-'))-- ATB Date([atb_dt]) ==> Marine Terminal Invoice " ).append("\n"); 
		query.append("                AND    H.TML_AGMT_OFC_CTY_CD = T.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("                AND    H.TML_AGMT_SEQ        = T.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("                AND    H.TML_AGMT_VER_NO     = T.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("                GROUP BY H.TML_AGMT_OFC_CTY_CD, H.TML_AGMT_SEQ, H.TML_AGMT_VER_NO," ).append("\n"); 
		query.append("                T.LGS_COST_CD, T.THRP_LGS_COST_CD ) A, TES_TML_SO_COST C, TES_TML_AGMT_DTL D" ).append("\n"); 
		query.append("            WHERE  C.COST_CALC_MZD_CD = 'A'" ).append("\n"); 
		query.append("            AND    C.TML_AGMT_MGMT_CD = 'A'" ).append("\n"); 
		query.append("            AND    C.MRN_TML_FLG = 'Y' -- Marine Terminal Invoice" ).append("\n"); 
		query.append("            AND    D.TML_AGMT_OFC_CTY_CD = A.CTY" ).append("\n"); 
		query.append("            AND    D.TML_AGMT_SEQ = A.SEQ" ).append("\n"); 
		query.append("            AND    D.TML_AGMT_VER_NO  = A.NO" ).append("\n"); 
		query.append("            AND    C.LGS_COST_CD = D.LGS_COST_CD" ).append("\n"); 
		query.append("            AND    DECODE(A.CNT,0,DECODE(SUBSTR(C.LGS_COST_CD,1,2),'TP','N','Y'),'Y') = 'Y' " ).append("\n"); 
		query.append("            AND    D.THRP_COST_CD_FLG IS NULL" ).append("\n"); 
		query.append("        ) A," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT ltrim(regexp_substr((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                          from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                         where TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] " ).append("\n"); 
		query.append("                                           and TML_SO_SEQ=@[tml_so_seq]), '[^|]+', 1, level ) ,'|') as COST_CODE" ).append("\n"); 
		query.append("             FROM dual" ).append("\n"); 
		query.append("             connect by level<= ( length((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                            from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                           where TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] " ).append("\n"); 
		query.append("                                             and TML_SO_SEQ=@[tml_so_seq]))+1 - length(replace((select COST_CD_FTR_RMK" ).append("\n"); 
		query.append("                                                                                                  from tes_tml_so_hdr" ).append("\n"); 
		query.append("                                                                                                 where TML_SO_OFC_CTY_CD=@[tml_so_ofc_cty_cd] " ).append("\n"); 
		query.append("                                                                                                   and TML_SO_SEQ=@[tml_so_seq]), '|')) ) / length('|')" ).append("\n"); 
		query.append("        )B," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT DISTINCT CNTR_NO FROM CNTRLIST  --LIST ONLY를 통한 Verify에서 TES_FILE_INP_TMP테이블 생성이 안되어 WITH문으로 바꿈" ).append("\n"); 
		query.append("        ) C" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cost_cd_ftr_rmk} == '') " ).append("\n"); 
		query.append("	WHERE A.COST_CODE=B.COST_CODE(+)" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("	WHERE A.COST_CODE=B.COST_CODE -- hdr정보에 데이터 있으면 inner 없음 outter" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("    ) AA," ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT DISTINCT H.INV_NO, H.YD_CD, H.VNDR_SEQ, D.LGS_COST_CD, L.CNTR_NO" ).append("\n"); 
		query.append("     FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L" ).append("\n"); 
		query.append("     WHERE  H.YD_CD               = @[yd_cd]" ).append("\n"); 
		query.append("     AND    H.VNDR_SEQ            = @[vndr_seq]" ).append("\n"); 
		query.append("     AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     AND    H.TML_SO_SEQ          = D.TML_SO_SEQ" ).append("\n"); 
		query.append("     AND    H.TML_SO_OFC_CTY_CD   = L.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     AND    H.TML_SO_SEQ          = L.TML_SO_SEQ" ).append("\n"); 
		query.append("     AND    L.VSL_CD              = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("     AND    L.SKD_VOY_NO          = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("     AND    L.SKD_DIR_CD          = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("     AND    L.IO_BND_CD           = @[io_bnd_cd]     " ).append("\n"); 
		query.append("     AND    D.VSL_CD              = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("     AND    D.SKD_VOY_NO          = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("     AND    D.SKD_DIR_CD          = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("     AND    D.IO_BND_CD           = @[io_bnd_cd]                     " ).append("\n"); 
		query.append("     AND    NVL(H.DELT_FLG,'N')   <> 'Y'" ).append("\n"); 
		query.append("     AND    D.CALC_TP_CD          = 'A'" ).append("\n"); 
		query.append("     AND    L.VRFY_RSLT_IND_CD    = 'CO'" ).append("\n"); 
		query.append("	 AND    H.TML_INV_TP_CD       = 'TM'" ).append("\n"); 
		query.append("     AND   (DECODE(L.STV_RVIS_IND_FLG,'Y','','SV') LIKE SUBSTR(D.LGS_COST_CD,1,2)||'%' OR DECODE(L.TML_RVIS_IND_FLG,'Y','','TM') LIKE SUBSTR(D.LGS_COST_CD,1,2)||'%'" ).append("\n"); 
		query.append("            OR DECODE(L.RVIS_IND_FLG,'Y','','TP') LIKE SUBSTR(D.LGS_COST_CD,1,2)||'%' OR DECODE(L.CGO_RVIS_IND_FLG,'Y','','CG') LIKE SUBSTR(D.LGS_COST_CD,1,2)||'%'" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("     AND    NVL(L.CNTR_TPSZ_CD,'N')  = NVL(D.CNTR_TPSZ_CD,'N')" ).append("\n"); 
		query.append("     AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("         = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("     AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("         = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("     AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("         = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("     AND    DECODE(H.TML_INV_TP_CD,'TM'," ).append("\n"); 
		query.append("        DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T',DECODE(L.CNTR_STY_CD,'F','TS','TM'),DECODE(L.CNTR_STY_CD,'F','FL','MT')))," ).append("\n"); 
		query.append("        'ON',DECODE(L.CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))" ).append("\n"); 
		query.append("         = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR(D.LGS_COST_CD,6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2)," ).append("\n"); 
		query.append("        'ST',SUBSTR(D.LGS_COST_CD,5,2))" ).append("\n"); 
		query.append("     AND    DECODE(H.TML_INV_TP_CD,'TM',NVL(L.DCGO_CLSS_CD,'N'),'ON',NVL(L.DCGO_CLSS_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("         = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.DCGO_IND_CD,'N'),'ON',NVL(D.DCGO_IND_CD,'N'),'OF','N','ST','N')" ).append("\n"); 
		query.append("     AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(D.TML_TRNS_MOD_CD,'','S','S','S',NVL(L.TML_TRNS_MOD_CD,'S')),'N')" ).append("\n"); 
		query.append("         = DECODE(H.TML_INV_TP_CD,'TM',NVL(D.TML_TRNS_MOD_CD,'S'),'N')" ).append("\n"); 
		query.append("     AND    DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS','F','N'),'N')" ).append("\n"); 
		query.append("         = DECODE(H.TML_INV_TP_CD,'TM',DECODE(SUBSTR(D.LGS_COST_CD,5,2),'TS',L.CNTR_STY_CD,'N'),'N')" ).append("\n"); 
		query.append("     AND    DECODE(H.TML_INV_TP_CD,'TM','Y',L.VSL_CD) <> DECODE(H.TML_INV_TP_CD,'TM','N','CNTC')" ).append("\n"); 
		query.append("    ) BB" ).append("\n"); 
		query.append("    WHERE AA.CNTR_NO = BB.CNTR_NO" ).append("\n"); 
		query.append("    AND   AA.COST_CODE = BB.LGS_COST_CD " ).append("\n"); 
		query.append("    GROUP BY BB.CNTR_NO)" ).append("\n"); 
		query.append("SELECT CNTRLIST.CNTR_NO,  CNTRLIST.CNTR_TPSZ_CD,  CNTRLIST.CNTR_STY_CD,  CNTRLIST.IOC_CD,  CNTRLIST.LANE_CD,  CNTRLIST.LANE_CD2,  CNTRLIST.SUB_TRD_CD,  CNTRLIST.LOCL_TS_IND_CD,  " ).append("\n"); 
		query.append("       CNTRLIST.RCVDE_TERM_IND_CD, CNTRLIST.BKG_NO, CNTRLIST.IO_BND_CD, CNTRLIST.DCGO_CLSS_CD, CNTRLIST.BB_CGO_FLG, CNTRLIST.AWK_CGO_FLG, CNTRLIST.RC_FLG,  " ).append("\n"); 
		query.append("       DECODE(CNTRLIST.CNTR_STY_CD, 'R', CNTRLIST.CNTR_RMK||DB.CNTR_RMK||' The booking is Empty Revenue Booking, so please select the relevant status.', CNTRLIST.CNTR_RMK||DB.CNTR_RMK) AS CNTR_RMK,  " ).append("\n"); 
		query.append("       CASE WHEN LENGTH(DB.CNTR_RMK) > 1   " ).append("\n"); 
		query.append("            THEN 'DB'" ).append("\n"); 
		query.append("            ELSE 'HO'" ).append("\n"); 
		query.append("		END DSCR_IND_CD,  CNTRLIST.VVD,  CNTRLIST.VSL_CD,  CNTRLIST.SKD_VOY_NO,  CNTRLIST.SKD_DIR_CD,  CNTRLIST.ATB_DT,  CNTRLIST.VNDR_SEQ,  CNTRLIST.TML_TRNS_MOD_CD,  " ).append("\n"); 
		query.append("       CNTRLIST.DSCR_DTL_IND_CD, CNTRLIST.WRK_DT, CNTRLIST.BL_NO, CNTRLIST.BL_NO_TP, CNTRLIST.BL_NO_CHK, CNTRLIST.DC_FLG,  " ).append("\n"); 
		query.append("#if (${file_import_yn} == 'Y')" ).append("\n"); 
		query.append("	   CNTRLIST.VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("#elseif (${file_import_yn} == 'N')" ).append("\n"); 
		query.append("       DECODE(CNTRLIST.IO_BND_CD, LOWER(@[io_bnd_cd]), 'DC', DECODE(CASE WHEN LENGTH(DB.CNTR_RMK) > 1   " ).append("\n"); 
		query.append("                                                                         THEN 'DB'" ).append("\n"); 
		query.append("                                                                         ELSE 'HO'" ).append("\n"); 
		query.append("				                                                     END , 'DB', 'DC', 'CO')) VRFY_RSLT_IND_CD" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end				                                                     " ).append("\n"); 
		query.append("FROM CNTRLIST,  DB" ).append("\n"); 
		query.append("WHERE CNTRLIST.CNTR_NO = DB.CNTR_NO(+)" ).append("\n"); 
		query.append("AND IO_BND_CD IN (@[io_bnd_cd],LOWER(@[io_bnd_cd]))" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${all_tp} == 'N' and  ${fm_tp_length} == '1')" ).append("\n"); 
		query.append("	AND CNTR_STY_CD = @[fm_tp]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${all_tp} == 'N' and  ${ts_tp_length} == '1')" ).append("\n"); 
		query.append("	AND LOCL_TS_IND_CD = @[ts_tp]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}