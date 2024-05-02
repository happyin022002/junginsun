/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301BlMain2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301BlMain2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301BlMain2
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301BlMain2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_old_rtn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301BlMain2RSQL").append("\n"); 
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
		query.append("SELECT 'CANCEL_BIT:'		|| BB.BKG_STS_CD											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CARGOTYPE:'			|| BB.BKG_CGO_TP_CD											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'DR_IND:'			|| decode(BB.DCGO_FLG,'Y','1','0')							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_IND:'			|| decode(BB.RC_FLG,'Y','1','0')							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'AK_IND:'			|| decode(BB.AWK_CGO_FLG,'Y','1','0') 				 		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BB_IND:'			|| decode(BB.BB_CGO_FLG,'Y','1','0')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HD_IND:'			|| decode(BB.SPCL_HIDE_FLG,'Y','1','0')				 		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'UD_IND:'			|| decode(nvl(length(trim(BB.STWG_CD)),0),0,'0','1')		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'UD_CD:'				|| BB.STWG_CD     									 		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RD_IND:'			|| decode(BB.RD_CGO_FLG,'Y','1','0')				 		|| CHR(10)" ).append("\n"); 
		query.append("	|| 'FG_IND:'			|| decode(BB.FD_GRD_FLG,'Y','1','0')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_CA:'				|| RF.CTRL_ATMS_FLG											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'RF_MA:'				|| RF.MODI_ATMS_FLG											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SOC_IND:'			|| decode(BB.SOC_FLG,'Y','1','0')							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'HANGER_IND:'		|| decode(BB.HNGR_FLG,'Y','1','0')							|| CHR(10)" ).append("\n"); 
		query.append("	|| 'EQSUB_IND:'			|| decode(BB.EQ_SUBST_FLG,'Y','1','0')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SALES_OFFICE:'		|| BB.OB_SLS_OFC_CD											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'SALES_NAME:'		|| BKG_SPCLCHAR_CONV_FNC(MSR.SREP_NM,'E')					|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_STF:'	   	 	|| BB.DOC_USR_ID											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_STF_NAME:'		|| BKG_SPCLCHAR_CONV_FNC(CU.USR_NM,'E')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_STF_TEL:'		|| CU.XTN_PHN_NO				                 	       	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_STF_FAX:'		|| CU.FAX_NO  											    || CHR(10)" ).append("\n"); 
		query.append("	|| 'CONTACT_NAME:'		|| BKG_SPCLCHAR_CONV_FNC(BCP.CNTC_PSON_NM,'E')				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CONTACT_TEL:'		|| BCP.CNTC_PSON_PHN_NO										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CONTACT_MOBILE:'	|| BCP.CNTC_PSON_MPHN_NO									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BOUND_IND:'			|| 'E'														|| CHR(10)" ).append("\n"); 
		query.append("	|| 'REGIONAL_BKGNBR:'	|| BP_PSA.CUST_REF_NO_CTNT									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'CUST_REF_NO:'		|| BB.XTER_BKG_RQST_REF_NO									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'REF_VOYAGE:'	                                                    		    || CHR(10)" ).append("\n"); 
		query.append("	|| 'SO_NO:'				|| BB.TWN_SO_NO											    || CHR(10)" ).append("\n"); 
		query.append("	|| 'BLKSTWG:'   		||BB.BLCK_STWG_CD                           				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'EQPICKDT:'			||TO_CHAR(BB.MTY_PKUP_DT,'RRRRMMDDHH24MI')				    || CHR(10)" ).append("\n"); 
		query.append("    || 'EQPICKDT_GMT:'		||TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(MTY_PKUP_YD_CD,1,5),BB.MTY_PKUP_DT,'GMT'),'RRRRMMDDHH24MI') || CHR(10)" ).append("\n"); 
		query.append("    || 'EQRTNDT:'	   		||NVL(TO_CHAR(BCT.MNL_SET_DT, 'yyyymmddhh24mi'),NVL(TO_CHAR(BCT.SYS_SET_DT, 'yyyymmddhh24mi'),'')) || CHR(10)" ).append("\n"); 
		query.append("    || 'EQRTNDT_GMT:'		||NVL(TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC(SUBSTR(BB.FULL_RTN_YD_CD,1,5),NVL(BCT.MNL_SET_DT,BCT.SYS_SET_DT),'GMT'), 'yyyymmddhh24mi'),'') || CHR(10)" ).append("\n"); 
		query.append("	|| 'EQRTN:'	    		||BB.FULL_RTN_YD_CD						                    || CHR(10)" ).append("\n"); 
		query.append("    || 'EQRTN_AMSQUAL:'	    || (SELECT DECODE(LENGTH(ML.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ') FROM MDM_LOCATION ML WHERE ML.LOC_CD = SUBSTR(BB.FULL_RTN_YD_CD,1,5))	|| CHR(10)" ).append("\n"); 
		query.append("    || 'EQRTN_AMSPORT:'	    || (SELECT ML.LOC_AMS_PORT_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD = SUBSTR(BB.FULL_RTN_YD_CD,1,5))	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'OLDEQRTN:'			||@[edi_old_rtn]											|| CHR(10)" ).append("\n"); 
		query.append("    || 'OLDEQRTN_AMSQUAL:'	|| (SELECT DECODE(LENGTH(ML.LOC_AMS_PORT_CD), 4, 'D', 5, 'K', ' ') FROM MDM_LOCATION ML WHERE ML.LOC_CD = SUBSTR(@[edi_old_rtn],1,5))	|| CHR(10)" ).append("\n"); 
		query.append("    || 'OLDEQRTN_AMSPORT:'	|| (SELECT ML.LOC_AMS_PORT_CD FROM MDM_LOCATION ML WHERE ML.LOC_CD = SUBSTR(@[edi_old_rtn],1,5))	|| CHR(10)" ).append("\n"); 
		query.append("    || 'FINAL_CFM_DT:'		||(SELECT TO_CHAR(EVNT_DT, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("								 FROM BKG_DOC_PROC_SKD SKD" ).append("\n"); 
		query.append("								WHERE BKG_DOC_PROC_TP_CD = 'CNTCFM'" ).append("\n"); 
		query.append("								  AND SKD.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("								  AND SKD.DOC_PERF_DELT_FLG = 'N')						|| CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_CNT:'  		||PU_CY.N1ST_VNDR_CNT_CD									|| CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_NM:'   		||BKG_SPCLCHAR_CONV_FNC(replace(replace(PU_CY.YD_NM, chr(13), ' '), chr(10), ''),'E')	|| CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR1:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(PU_CY.yd_addr, chr(13), ' '), chr(10), ' '), 1, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR2:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(PU_CY.yd_addr, chr(13), ' '), chr(10), ' '), 2, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR3:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(PU_CY.yd_addr, chr(13), ' '), chr(10), ' '), 3, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR4:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(PU_CY.yd_addr, chr(13), ' '), chr(10), ' '), 4, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("	|| 'PUCY_ADDR5:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(PU_CY.yd_addr, chr(13), ' '), chr(10), ' '), 5, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("    || 'PUCY_VND:'		    ||''                                                   || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_CNT:'  		||RT_CY.N1ST_VNDR_CNT_CD                                    || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_NM:'   		||BKG_SPCLCHAR_CONV_FNC(replace(replace(RT_CY.YD_NM, chr(13), ' '), chr(10), ''),'E')  || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR1:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(RT_CY.yd_addr, chr(13), ' '), chr(10), ' '), 1, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR2:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(RT_CY.yd_addr, chr(13), ' '), chr(10), ' '), 2, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR3:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(RT_CY.yd_addr, chr(13), ' '), chr(10), ' '), 3, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR4:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(RT_CY.yd_addr, chr(13), ' '), chr(10), ' '), 4, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("	|| 'RTCY_ADDR5:'		||BKG_SPCLCHAR_CONV_FNC(BKG_TOKEN_NL_FNC(replace(replace(RT_CY.yd_addr, chr(13), ' '), chr(10), ' '), 5, ''),'E') || CHR(10)" ).append("\n"); 
		query.append("	|| 'BL_PO_NO:'			||replace(replace(BP_PO.CUST_REF_NO_CTNT, chr(13), ''), chr(10), '')   || CHR(10)" ).append("\n"); 
		query.append("	|| 'BL_SI_NO:'  		||BB.XTER_SI_REF_NO											|| CHR(10)" ).append("\n"); 
		query.append("	|| 'DST_TRANS:' 		||CASE WHEN @[edi_type] = '301M' THEN 'T'" ).append("\n"); 
		query.append("                              ELSE (SELECT DECODE(SUBSTR(MA.ACT_NM,1,1),'O','T',SUBSTR(MA.ACT_NM,1,1))" ).append("\n"); 
		query.append("                                     FROM SCE_COP_HDR HDR" ).append("\n"); 
		query.append("                                         ,SCE_COP_DTL DTL" ).append("\n"); 
		query.append("                                         ,MDM_ACTIVITY MA" ).append("\n"); 
		query.append("                                    WHERE HDR.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("                                      AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("                                      AND DTL.NOD_CD = BB.Full_Rtn_Yd_Cd" ).append("\n"); 
		query.append("                                      AND DTL.ACT_CD = MA.ACT_CD" ).append("\n"); 
		query.append("                                      AND HDR.COP_STS_CD <> 'X'" ).append("\n"); 
		query.append("                                      AND DTL.ACT_CD NOT IN ('FLVMLO','FLVMDO','FORRLO','FORRDO','MITYAD','FITMDO','FOWMDO','FLWMDO','FOWMLO','FLWMLO')" ).append("\n"); 
		query.append("                                      AND DTL.COP_DTL_SEQ = (SELECT max(DTL1.COP_DTL_SEQ) FROM SCE_COP_DTL DTL1 " ).append("\n"); 
		query.append("                                                             WHERE DTL1.COP_NO = DTL.COP_NO AND DTL1.NOD_CD = DTL.NOD_CD " ).append("\n"); 
		query.append("                                                             AND DTL1.ACT_CD NOT IN ('FLVMLO','FLVMDO','FORRLO','FORRDO','MITYAD','FITMDO','FOWMDO','FLWMDO','FOWMLO','FLWMLO'))" ).append("\n"); 
		query.append("                                      AND ROWNUM = 1	)	END								|| CHR(10)" ).append("\n"); 
		query.append("	|| 'BKG_FLEX_IND:' 		||NVL(decode(BB.FLEX_HGT_FLG,'Y','1','0'),'0')				|| CHR(10) BL_MAIN2" ).append("\n"); 
		query.append("FROM	BKG_BOOKING	BB," ).append("\n"); 
		query.append("        BKG_VVD VVD," ).append("\n"); 
		query.append("        VSK_VSL_PORT_SKD VVPS1," ).append("\n"); 
		query.append("		BKG_RF_CGO RF, " ).append("\n"); 
		query.append("		COM_USER CU, " ).append("\n"); 
		query.append("		MDM_YARD PU_CY, " ).append("\n"); 
		query.append("		MDM_YARD RT_CY," ).append("\n"); 
		query.append("		BKG_CNTC_PSON BCP, " ).append("\n"); 
		query.append("		BKG_REFERENCE BP_PSA, " ).append("\n"); 
		query.append("		BKG_REFERENCE BP_PO," ).append("\n"); 
		query.append("		MDM_SLS_REP MSR," ).append("\n"); 
		query.append("		BKG_CLZ_TM BCT" ).append("\n"); 
		query.append("WHERE	BB.BKG_NO	   = @[bkg_no]" ).append("\n"); 
		query.append("AND     BB.BKG_NO          = VVD.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BB.POL_CD          = VVD.POL_CD(+)	" ).append("\n"); 
		query.append("AND     BB.BKG_NO          = RF.BKG_NO(+)	" ).append("\n"); 
		query.append("AND     BB.BKG_NO          = BCP.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BCP.BKG_CNTC_PSON_TP_CD(+) = 'BK'	" ).append("\n"); 
		query.append("AND     BB.BKG_NO          = BP_PSA.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BP_PSA.bkg_ref_tp_cd(+) = 'PSAN'" ).append("\n"); 
		query.append("AND     BB.BKG_NO          = BP_PO.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BP_PO.bkg_ref_tp_cd(+) = 'BKPO'	" ).append("\n"); 
		query.append("AND     VVD.VSL_CD		   = VVPS1.VSL_CD(+)" ).append("\n"); 
		query.append("AND     VVD.SKD_VOY_NO	   = VVPS1.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("AND     VVD.SKD_DIR_CD	   = VVPS1.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("AND     VVD.POL_CD 		   = VVPS1.VPS_PORT_CD(+)" ).append("\n"); 
		query.append("AND     VVD.POL_CLPT_IND_SEQ = VVPS1.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("AND     UPPER(BB.DOC_USR_ID) = UPPER(CU.USR_ID(+))" ).append("\n"); 
		query.append("AND     BB.OB_SREP_CD   = MSR.SREP_CD(+)" ).append("\n"); 
		query.append("AND     BB.MTY_PKUP_YD_CD = PU_CY.yd_cd(+)" ).append("\n"); 
		query.append("AND     BB.FULL_RTN_YD_CD = RT_CY.yd_cd(+)" ).append("\n"); 
		query.append("AND     BB.BKG_NO         = BCT.BKG_NO(+)" ).append("\n"); 
		query.append("AND     BCT.CLZ_TP_CD(+)  = 'R'" ).append("\n"); 

	}
}