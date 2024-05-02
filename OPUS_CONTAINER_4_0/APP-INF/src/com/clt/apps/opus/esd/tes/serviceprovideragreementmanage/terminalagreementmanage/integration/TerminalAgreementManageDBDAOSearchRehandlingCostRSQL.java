/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalAgreementManageDBDAOSearchRehandlingCostRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.30
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.30 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yOng hO lEE
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TerminalAgreementManageDBDAOSearchRehandlingCostRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 요청된 Port에서 Re-handling될 화물의 Cost를 산출한다.
	  * </pre>
	  */
	public TerminalAgreementManageDBDAOSearchRehandlingCostRSQL(){
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
		params.put("rat_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rat_as_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rhnd_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.integration").append("\n"); 
		query.append("FileName : TerminalAgreementManageDBDAOSearchRehandlingCostRSQL").append("\n"); 
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
		query.append("SELECT	@[bkg_no] AS bkg_no" ).append("\n"); 
		query.append(", @[chg_cd] AS chg_cd" ).append("\n"); 
		query.append(", @[rat_ut_cd] AS rat_ut_cd" ).append("\n"); 
		query.append(", @[rat_as_qty] AS rat_as_qty" ).append("\n"); 
		query.append(", @[cgo_cate_cd] AS cgo_cate_cd" ).append("\n"); 
		query.append(", @[cod_rqst_seq] AS cod_rqst_seq" ).append("\n"); 
		query.append(", @[cntr_cgo_tp_cd] AS cntr_cgo_tp_cd" ).append("\n"); 
		query.append(", RATE AS chg_ut_amt" ).append("\n"); 
		query.append(", CURR_CD AS curr_cd" ).append("\n"); 
		query.append(", RATE * @[rat_as_qty] AS chg_amt" ).append("\n"); 
		query.append("FROM   ( SELECT D.CURR_CD CURR_CD," ).append("\n"); 
		query.append("MAX(DECODE(DECODE(D.LGS_COST_CD,'SVRHCD',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0," ).append("\n"); 
		query.append("DECODE(DECODE(D.LGS_COST_CD,'TPNDTS',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0),0," ).append("\n"); 
		query.append("DECODE(DECODE(D.LGS_COST_CD,DECODE(@[cntr_cgo_tp_cd],'F','TPNDFL','TPNDMT'),DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0),0," ).append("\n"); 
		query.append("DECODE(DECODE(D.LGS_COST_CD,'SVLDTS',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0) +" ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,'TMNDTS',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0),0," ).append("\n"); 
		query.append("DECODE(DECODE(D.LGS_COST_CD,DECODE(@[cntr_cgo_tp_cd],'F','SVLDFL','SVLDMT'),DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0) +" ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,DECODE(@[cntr_cgo_tp_cd],'F','TMNDFL','TMNDMT'),DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0),0,0," ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,DECODE(@[cntr_cgo_tp_cd],'F','SVLDFL','SVLDMT'),DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0) +" ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,DECODE(@[cntr_cgo_tp_cd],'F','TMNDFL','TMNDMT'),DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0))," ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,'SVLDTS',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0) +" ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,'TMNDTS',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0))," ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,DECODE(@[cntr_cgo_tp_cd],'F','TPNDFL','TPNDMT'),DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0))," ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,'TPNDTS',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0),0))," ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,'SVRHCD',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD, @[rat_ut_cd],C.AGMT_RT,0),D.AGMT_UT_RT),0))) RATE" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD   V, TES_TML_AGMT_HDR         H, TES_TML_AGMT_DTL   D," ).append("\n"); 
		query.append("TES_TML_AGMT_TP_SZ C, TES_TML_AGMT_DG_CGO_CLSS G, TES_TML_AGMT_APLY_DY A" ).append("\n"); 
		query.append("WHERE  V.VSL_CD          = SUBSTR( @[vvd], 1, 4 )		--'HNAT'          --:vsl_cd" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO      = SUBSTR( @[vvd], 5, 4 )	--'0057'          --:skd_voy_cd" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD      = SUBSTR( @[vvd], 9, 1 )	--'W'             --:skd_dir_cd" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD     = SUBSTR( @[cod_rhnd_port_cd], 1, 5 )		--'CNHKG'         --:cod_port(COD 요청 PORT)" ).append("\n"); 
		query.append("AND    V.YD_CD           = H.YD_CD" ).append("\n"); 
		query.append("AND    H.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("AND    H.TML_AGMT_VER_NO = ( SELECT MAX(M.TML_AGMT_VER_NO)" ).append("\n"); 
		query.append("FROM   TES_TML_AGMT_HDR M" ).append("\n"); 
		query.append("WHERE  M.YD_CD           = H.YD_CD" ).append("\n"); 
		query.append("AND    M.VNDR_SEQ        = H.VNDR_SEQ" ).append("\n"); 
		query.append("AND    M.TML_AGMT_STS_CD = 'C'" ).append("\n"); 
		query.append("AND    M.DELT_FLG        = 'N' )" ).append("\n"); 
		query.append("AND    H.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD" ).append("\n"); 
		query.append("AND    H.TML_AGMT_SEQ        = D.TML_AGMT_SEQ" ).append("\n"); 
		query.append("AND    H.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO" ).append("\n"); 
		query.append("AND    D.LGS_COST_CD         IN ('SVRHCD','TPNDTS','SVLDTS','TMNDTS','TPNDFL','TPNDMT','SVLDFL','SVLDMT','TMNDFL','TMNDMT')" ).append("\n"); 
		query.append("AND    NVL(D.THRP_COST_CD_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    TO_NUMBER(NVL(D.FM_TR_VOL_VAL,'1')) = 1" ).append("\n"); 
		query.append("AND    NVL(D.LANE_CD,'N')    = DECODE(NVL(D.LANE_CD,'N'),'N','N','Sam','Sam','OTH','OTH','CMA')" ).append("\n"); 
		query.append("AND    NVL(D.IOC_CD,'N')     IN ('N','S','O')" ).append("\n"); 
		query.append("AND    NVL(D.IO_BND_CD,'N')  IN ('N','S','O')" ).append("\n"); 
		query.append("AND    NVL(D.TML_TRNS_MOD_CD,'N') = DECODE(NVL(D.TML_TRNS_MOD_CD,'N'),'N','N','S','S',D.TML_TRNS_MOD_CD)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_OFC_CTY_CD = C.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_SEQ        = C.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_VER_NO     = C.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_DTL_SEQ    = C.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(D.TML_AGMT_VOL_UT_CD,'C',C.CNTR_TPSZ_CD,'N') = DECODE(D.TML_AGMT_VOL_UT_CD,'C', @[rat_ut_cd],'N')" ).append("\n"); 
		query.append("AND    D.TML_AGMT_OFC_CTY_CD = G.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_SEQ        = G.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_VER_NO     = G.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N',D.TML_AGMT_DTL_SEQ)" ).append("\n"); 
		query.append("= DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N',G.TML_AGMT_DTL_SEQ)" ).append("\n"); 
		query.append("AND    DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N',G.DCGO_APLY_TP_CD) = DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'N','N','R')" ).append("\n"); 
		query.append("AND    DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'A',DECODE('N','N',G.DCGO_NON_CLSS_FLG,'N'),'S',DECODE('N','N',G.DCGO_NON_CLSS_FLG,'N'),'N')" ).append("\n"); 
		query.append("= DECODE(NVL(D.DCGO_APLY_TP_CD,'N'),'A',DECODE('N','N','Y','N'),'S',DECODE('N','N','Y','N'),'N')" ).append("\n"); 
		query.append("AND    D.TML_AGMT_OFC_CTY_CD  = A.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_SEQ         = A.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_VER_NO      = A.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_DTL_SEQ     = A.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY D.CURR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RATE <> 0" ).append("\n"); 

	}
}