/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListCNTCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.18 
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

public class MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListCNTCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchCOMListOnlyListCNTC
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListCNTCRSQL(){
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchCOMListOnlyListCNTCRSQL").append("\n"); 
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
		query.append("SELECT O.EQ_NO 																CNTR_NO," ).append("\n"); 
		query.append("		  O.EQ_TPSZ_CD 															CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		  O.CGO_TP_CD 															CNTR_STY_CD," ).append("\n"); 
		query.append("		  DECODE(BR.CONTI_CD,BD.CONTI_CD,DECODE(BR.CNT_CD,BD.CNT_CD,'IPC','OCN'),'OCN')	IOC_CD, -- 20160218 IPC/OCN을 Domestic/International 개념으로 바꿈" ).append("\n"); 
		query.append("		  B.SLAN_CD 															LANE_CD," ).append("\n"); 
		query.append("		  B.SLAN_CD 															LANE_CD2," ).append("\n"); 
		query.append("		  C.SUB_TRD_CD                                                          SUB_TRD_CD," ).append("\n"); 
		query.append("		  'L' 																	LOCL_TS_IND_CD," ).append("\n"); 
		query.append("		  B.RCV_TERM_CD||'/'||B.DE_TERM_CD 										RCVDE_TERM_IND_CD," ).append("\n"); 
		query.append("		  O.BKG_NO 																BKG_NO," ).append("\n"); 
		query.append("		  --O.BKG_NO_SPLIT 														BKG_NO_SPLIT," ).append("\n"); 
		query.append("		  DECODE(@[yd_cd],O.FM_NOD_CD,'O',DECODE(@[yd_cd],O.TO_NOD_CD,'I'),NULL) 			IO_BND_CD," ).append("\n"); 
		query.append("		  NVL(SUBSTR(D.IMDG_CLSS_CD,1,1),'N') 								DCGO_CLSS_CD," ).append("\n"); 
		query.append("		  NVL(B.BB_CGO_FLG,'N') 											BB_CGO_FLG," ).append("\n"); 
		query.append("		  DECODE(NVL(B.BB_CGO_FLG,'N'),'Y','Break Bulk') 					CNTR_RMK," ).append("\n"); 
		query.append("		   'HO'																	DSCR_IND_CD," ).append("\n"); 
		query.append("		   'COM List Only'														DSCR_IND_NM," ).append("\n"); 
		query.append("		  @[vvd]																	VVD," ).append("\n"); 
		query.append("		  SUBSTR(@[vvd],1,4)														VSL_CD," ).append("\n"); 
		query.append("		  SUBSTR(@[vvd],5,4)														SKD_VOY_NO," ).append("\n"); 
		query.append("		  SUBSTR(@[vvd],9,1)														SKD_DIR_CD," ).append("\n"); 
		query.append("		  @[vndr_seq]																	VNDR_SEQ," ).append("\n"); 
		query.append("		  'DC'																	VRFY_RSLT_IND_CD," ).append("\n"); 
		query.append("		  'Y'																	DC_FLG" ).append("\n"); 
		query.append("   FROM   TRS_TRSP_SVC_ORD O, BKG_BOOKING B, BKG_DG_CGO D, MDM_LOCATION BR, MDM_LOCATION BD, COA_RGST_BKG C" ).append("\n"); 
		query.append("   WHERE  O.VSL_CD       = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND    O.SKD_VOY_NO   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND    O.SKD_DIR_CD   = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("   AND    ( O.FM_NOD_CD  = @[yd_cd]" ).append("\n"); 
		query.append("   OR     O.TO_NOD_CD    = @[yd_cd] )" ).append("\n"); 
		query.append("   --AND    O.EQ_TP_CD     = 'C' -- 2010.0107 EQ_KND_CD로 통합됨 " ).append("\n"); 
		query.append("   AND    O.EQ_KND_CD     = 'U' --2010.0408 C에서 U로 변경" ).append("\n"); 
		query.append("   AND    NVL(O.DELT_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("   AND    O.TRSP_CRR_MOD_CD LIKE '%W%'" ).append("\n"); 
		query.append("   AND    O.CRE_DT < TO_DATE(@[rcv_dt],'YYYYMMDD') + 15" ).append("\n"); 
		query.append("   AND    O.BKG_NO       = B.BKG_NO(+)" ).append("\n"); 
		query.append("   --AND    O.BKG_NO_SPLIT = B.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("   AND    B.BKG_NO       = D.BKG_NO(+)" ).append("\n"); 
		query.append("   AND    B.BKG_NO       = C.BKG_NO(+)" ).append("\n"); 
		query.append("   AND    B.SLAN_CD      = C.SLAN_CD(+)" ).append("\n"); 
		query.append("   AND    B.VSL_CD       = C.VSL_CD(+)" ).append("\n"); 
		query.append("   AND    B.SKD_VOY_NO   = C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND    B.SKD_DIR_CD   = C.DIR_CD(+)" ).append("\n"); 
		query.append("   --AND    B.BKG_NO_SPLIT = D.BKG_NO_SPLIT(+)" ).append("\n"); 
		query.append("   AND    B.POR_CD       = BR.LOC_CD(+)" ).append("\n"); 
		query.append("   AND    B.POD_CD       = BD.LOC_CD(+)" ).append("\n"); 

	}
}