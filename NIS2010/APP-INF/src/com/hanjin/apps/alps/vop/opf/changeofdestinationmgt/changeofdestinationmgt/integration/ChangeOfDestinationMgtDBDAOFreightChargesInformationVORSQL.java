/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOFreightChargesInformationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.10.08 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOFreightChargesInformationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dummy
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOFreightChargesInformationVORSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOFreightChargesInformationVORSQL").append("\n"); 
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
		query.append("WITH" ).append("\n"); 
		query.append("V_TEMP1 AS(" ).append("\n"); 
		query.append("SELECT TPSZ, SUM(CNT) QTY" ).append("\n"); 
		query.append("FROM ( SELECT DISTINCT DECODE(A.POS,'D',B.TPSZ,C.TPSZ) TPSZ, DECODE(A.POS,'D',B.CNT,C.CNT) CNT" ).append("\n"); 
		query.append("FROM ( SELECT DECODE(COUNT(B.ID),0,'D','H') POS" ).append("\n"); 
		query.append("FROM   BKG_COD M, BKG_COD_CNTR C, BAY_PLAN B" ).append("\n"); 
		query.append("WHERE  M.BKG_NO                    = @[bkg_no] --:bkg_no" ).append("\n"); 
		query.append("AND    M.COD_RQST_SEQ              = @[cod_rqst_seq] --:req_seq" ).append("\n"); 
		query.append("AND    M.BKG_NO                    = C.BKG_NO" ).append("\n"); 
		query.append("AND    M.COD_RQST_SEQ              = C.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND    M.OLD_VSL_CD                = B.VSL_CD" ).append("\n"); 
		query.append("AND    M.OLD_SKD_VOY_NO            = B.VOY_NO" ).append("\n"); 
		query.append("AND    M.OLD_SKD_DIR_CD            = B.DIR_CD" ).append("\n"); 
		query.append("AND    SUBSTR(M.OLD_POD_YD_CD,1,5) = B.POD_ISO          --20091008 수정" ).append("\n"); 
		query.append("AND    C.CNTR_NO                   = B.ID" ).append("\n"); 
		query.append("AND    TIER                        < '80' ) A," ).append("\n"); 
		query.append("( SELECT TPSZ, COUNT(CNTR) CNT" ).append("\n"); 
		query.append("FROM   ( SELECT DISTINCT" ).append("\n"); 
		query.append("NVL(T.CNTR_TPSZ_CD,DECODE(C.CNTR_TYPE,'N','D',C.CNTR_TYPE)||" ).append("\n"); 
		query.append("DECODE(C.CNTR_SIZE,'2','2','3','3','4','4','H','5','L','7'))       TPSZ," ).append("\n"); 
		query.append("C.ID CNTR" ).append("\n"); 
		query.append("FROM   BKG_COD H, BKG_COD_CNTR D, BAY_PLAN B, BAY_PLAN C, MDM_CNTR_TP_SZ T, VSK_VSL_PORT_SKD M, VSK_VSL_PORT_SKD S  --20091008 수정" ).append("\n"); 
		query.append("WHERE  H.BKG_NO                    = @[bkg_no]       --:bkg_no" ).append("\n"); 
		query.append("AND    H.COD_RQST_SEQ              = @[cod_rqst_seq] --:req_seq" ).append("\n"); 
		query.append("AND    H.BKG_NO                    = D.BKG_NO" ).append("\n"); 
		query.append("AND    H.COD_RQST_SEQ              = D.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND    H.OLD_VSL_CD                = B.VSL_CD" ).append("\n"); 
		query.append("AND    H.OLD_SKD_VOY_NO            = B.VOY_NO" ).append("\n"); 
		query.append("AND    H.OLD_SKD_DIR_CD            = B.DIR_CD" ).append("\n"); 
		query.append("AND    SUBSTR(H.OLD_POD_YD_CD,1,5) = B.POD_ISO               --20091008 수정" ).append("\n"); 
		query.append("AND    D.CNTR_NO                   = B.ID" ).append("\n"); 
		query.append("AND    B.VSL_CD                    = C.VSL_CD" ).append("\n"); 
		query.append("AND    B.VOY_NO                    = C.VOY_NO" ).append("\n"); 
		query.append("AND    B.DIR_CD                    = C.DIR_CD" ).append("\n"); 
		query.append("AND    B.BAY                       = C.BAY" ).append("\n"); 
		query.append("AND    B.ROWW                      = C.ROWW" ).append("\n"); 
		query.append("AND    B.TIER                      < C.TIER" ).append("\n"); 
		query.append("AND    C.SZTP                      = T.CNTR_TPSZ_ISO_CD(+)   --20091008 수정" ).append("\n"); 
		query.append("AND    B.VSL_CD                    = M.VSL_CD" ).append("\n"); 
		query.append("AND    B.VOY_NO                    = M.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    B.DIR_CD                    = M.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    H.COD_RHND_PORT_CD          = M.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    C.VSL_CD                    = S.VSL_CD" ).append("\n"); 
		query.append("AND    C.VOY_NO                    = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    C.DIR_CD                    = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    C.POD_ISO                   = S.VPS_PORT_CD           --20091008 수정" ).append("\n"); 
		query.append("AND    M.CLPT_SEQ                  < S.CLPT_SEQ )" ).append("\n"); 
		query.append("GROUP BY TPSZ ) B FULL OUTER JOIN" ).append("\n"); 
		query.append("( SELECT TPSZ, COUNT(CNTR) CNT" ).append("\n"); 
		query.append("FROM   ( SELECT DISTINCT" ).append("\n"); 
		query.append("NVL(T.CNTR_TPSZ_CD,DECODE(C.CNTR_TYPE,'N','D',C.CNTR_TYPE)||" ).append("\n"); 
		query.append("DECODE(C.CNTR_SIZE,'2','2','3','3','4','4','H','5','L','7'))       TPSZ," ).append("\n"); 
		query.append("C.ID CNTR" ).append("\n"); 
		query.append("FROM   BKG_COD H, BKG_COD_CNTR D, BAY_PLAN B, BAY_PLAN C, MDM_CNTR_TP_SZ T, VSK_VSL_PORT_SKD M, VSK_VSL_PORT_SKD S   --20091008 수정" ).append("\n"); 
		query.append("WHERE  H.BKG_NO                    = @[bkg_no]       --:bkg_no" ).append("\n"); 
		query.append("AND    H.COD_RQST_SEQ              = @[cod_rqst_seq] --:req_seq" ).append("\n"); 
		query.append("AND    H.BKG_NO                    = D.BKG_NO" ).append("\n"); 
		query.append("AND    H.COD_RQST_SEQ              = D.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND    H.OLD_VSL_CD                = B.VSL_CD" ).append("\n"); 
		query.append("AND    H.OLD_SKD_VOY_NO            = B.VOY_NO" ).append("\n"); 
		query.append("AND    H.OLD_SKD_DIR_CD            = B.DIR_CD" ).append("\n"); 
		query.append("AND    SUBSTR(H.OLD_POD_YD_CD,1,5) = B.POD_ISO              --20091008 수정" ).append("\n"); 
		query.append("AND    D.CNTR_NO                   = B.ID" ).append("\n"); 
		query.append("AND    B.VSL_CD                    = C.VSL_CD" ).append("\n"); 
		query.append("AND    B.VOY_NO                    = C.VOY_NO" ).append("\n"); 
		query.append("AND    B.DIR_CD                    = C.DIR_CD" ).append("\n"); 
		query.append("AND    B.BAY                       = C.BAY" ).append("\n"); 
		query.append("AND    B.ROWW                      = C.ROWW" ).append("\n"); 
		query.append("AND    B.TIER                      < C.TIER" ).append("\n"); 
		query.append("AND    C.TIER                      < '80'" ).append("\n"); 
		query.append("AND    C.SZTP                      = T.CNTR_TPSZ_ISO_CD(+)  --20091008 수정" ).append("\n"); 
		query.append("AND    B.VSL_CD                    = M.VSL_CD" ).append("\n"); 
		query.append("AND    B.VOY_NO                    = M.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    B.DIR_CD                    = M.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    H.COD_RHND_PORT_CD          = M.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    C.VSL_CD                    = S.VSL_CD" ).append("\n"); 
		query.append("AND    C.VOY_NO                    = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    C.DIR_CD                    = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    C.POD_ISO                   = S.VPS_PORT_CD           --20091008 수정" ).append("\n"); 
		query.append("AND    M.CLPT_SEQ                  < S.CLPT_SEQ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DISTINCT" ).append("\n"); 
		query.append("NVL(T.CNTR_TPSZ_CD,DECODE(C.CNTR_TYPE,'N','D',C.CNTR_TYPE)||" ).append("\n"); 
		query.append("DECODE(C.CNTR_SIZE,'2','2','3','3','4','4','H','5','L','7'))       TPSZ," ).append("\n"); 
		query.append("C.ID CNTR" ).append("\n"); 
		query.append("FROM   BKG_COD H, BKG_COD_CNTR D, BAY_PLAN B, BAY_PLAN C, MDM_CNTR_TP_SZ T, VSK_VSL_PORT_SKD M, VSK_VSL_PORT_SKD S       --20091008 수정" ).append("\n"); 
		query.append("WHERE  H.BKG_NO                    = @[bkg_no]       --:bkg_no" ).append("\n"); 
		query.append("AND    H.COD_RQST_SEQ              = @[cod_rqst_seq] --:req_seq" ).append("\n"); 
		query.append("AND    H.BKG_NO                    = D.BKG_NO" ).append("\n"); 
		query.append("AND    H.COD_RQST_SEQ              = D.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND    H.OLD_VSL_CD                = B.VSL_CD" ).append("\n"); 
		query.append("AND    H.OLD_SKD_VOY_NO            = B.VOY_NO" ).append("\n"); 
		query.append("AND    H.OLD_SKD_DIR_CD            = B.DIR_CD" ).append("\n"); 
		query.append("AND    SUBSTR(H.OLD_POD_YD_CD,1,5) = B.POD_ISO     --20091008 수정" ).append("\n"); 
		query.append("AND    D.CNTR_NO                   = B.ID" ).append("\n"); 
		query.append("AND    B.VSL_CD                    = C.VSL_CD" ).append("\n"); 
		query.append("AND    B.VOY_NO                    = C.VOY_NO" ).append("\n"); 
		query.append("AND    B.DIR_CD                    = C.DIR_CD" ).append("\n"); 
		query.append("AND    B.BAY                       = C.BAY" ).append("\n"); 
		query.append("AND    C.TIER                      >= '80'" ).append("\n"); 
		query.append("AND    C.ROWW                      <= ( SELECT END_HLD_NO" ).append("\n"); 
		query.append("FROM   OPF_HTCH_CVR_LODG_LIST" ).append("\n"); 
		query.append("WHERE  VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("AND    VSL_BAY_NO = C.BAY" ).append("\n"); 
		query.append("AND    ST_HLD_NO  <= B.ROWW" ).append("\n"); 
		query.append("AND    END_HLD_NO >= B.ROWW )" ).append("\n"); 
		query.append("AND    C.ROWW                      >= ( SELECT ST_HLD_NO" ).append("\n"); 
		query.append("FROM   OPF_HTCH_CVR_LODG_LIST" ).append("\n"); 
		query.append("WHERE  VSL_CD     = C.VSL_CD" ).append("\n"); 
		query.append("AND    VSL_BAY_NO = C.BAY" ).append("\n"); 
		query.append("AND    ST_HLD_NO  <= B.ROWW" ).append("\n"); 
		query.append("AND    END_HLD_NO >= B.ROWW )" ).append("\n"); 
		query.append("AND    C.SZTP                      = T.CNTR_TPSZ_ISO_CD(+)             --20091008 수정" ).append("\n"); 
		query.append("AND    B.VSL_CD                    = M.VSL_CD" ).append("\n"); 
		query.append("AND    B.VOY_NO                    = M.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    B.DIR_CD                    = M.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    H.COD_RHND_PORT_CD          = M.VPS_PORT_CD" ).append("\n"); 
		query.append("AND    C.VSL_CD                    = S.VSL_CD" ).append("\n"); 
		query.append("AND    C.VOY_NO                    = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    C.DIR_CD                    = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    C.POD_ISO                   = S.VPS_PORT_CD                 --20091008 수정" ).append("\n"); 
		query.append("AND    M.CLPT_SEQ                  < S.CLPT_SEQ )" ).append("\n"); 
		query.append("GROUP BY TPSZ ) C" ).append("\n"); 
		query.append("ON B.TPSZ = C.TPSZ" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT T.CNTR_TPSZ_CD TPSZ, COUNT(C.CNTR_NO) CNT" ).append("\n"); 
		query.append("FROM   BKG_COD M, BKG_COD_CNTR C, BKG_BOOKING B, BKG_CONTAINER T" ).append("\n"); 
		query.append("WHERE  M.BKG_NO                    = @[bkg_no] --:bkg_no" ).append("\n"); 
		query.append("AND    M.COD_RQST_SEQ              = @[cod_rqst_seq] --:req_seq" ).append("\n"); 
		query.append("AND    M.BKG_NO                    = C.BKG_NO" ).append("\n"); 
		query.append("AND    M.COD_RQST_SEQ              = C.COD_RQST_SEQ" ).append("\n"); 
		query.append("AND    M.BKG_NO                    = B.BKG_NO" ).append("\n"); 
		query.append("AND    M.COD_RHND_PORT_CD          <> B.POD_CD" ).append("\n"); 
		query.append("AND    M.BKG_NO                    = T.BKG_NO" ).append("\n"); 
		query.append("AND    C.CNTR_NO                   = T.CNTR_NO" ).append("\n"); 
		query.append("GROUP BY T.CNTR_TPSZ_CD )" ).append("\n"); 
		query.append("GROUP BY TPSZ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("V_TEMP2 AS(" ).append("\n"); 
		query.append("SELECT D.CURR_CD CURR_CD," ).append("\n"); 
		query.append("MAX(NVL(DECODE(D.LGS_COST_CD,'SVRHCD',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT),0)," ).append("\n"); 
		query.append("NVL(DECODE(D.LGS_COST_CD,'TPNDTS',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT),0),0)," ).append("\n"); 
		query.append("NVL(DECODE(D.LGS_COST_CD,'TPNDFL',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT),0),0)," ).append("\n"); 
		query.append("NVL(DECODE(D.LGS_COST_CD,'SVLDTS',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT),0),0) +" ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,'TMNDTS',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT),0),0)," ).append("\n"); 
		query.append("NVL(DECODE(D.LGS_COST_CD,'SVLDFL',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT),0),0) +" ).append("\n"); 
		query.append("DECODE(D.LGS_COST_CD,'TMNDFL',DECODE(NVL(D.IO_BND_CD,'N')," ).append("\n"); 
		query.append("'S',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT)," ).append("\n"); 
		query.append("'O',DECODE(D.TML_AGMT_VOL_UT_CD,'C',DECODE(C.CNTR_TPSZ_CD,V_TEMP1.TPSZ,C.AGMT_RT,0),D.AGMT_UT_RT),0),0),0)))))) RATE" ).append("\n"); 
		query.append(",V_TEMP1.TPSZ TPSZ, V_TEMP1.QTY QTY" ).append("\n"); 
		query.append("FROM   VSK_VSL_PORT_SKD   V, TES_TML_AGMT_HDR         H, TES_TML_AGMT_DTL   D," ).append("\n"); 
		query.append("TES_TML_AGMT_TP_SZ C, TES_TML_AGMT_DG_CGO_CLSS G, TES_TML_AGMT_APLY_DY A" ).append("\n"); 
		query.append(",      V_TEMP1" ).append("\n"); 
		query.append("WHERE  V.VSL_CD          = SUBSTR(@[vvd], 1, 4) --:vsl_cd" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO      = SUBSTR(@[vvd], 5, 4) --:skd_voy_cd" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD      = SUBSTR(@[vvd], -1) --:skd_dir_cd" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD     = @[cod_rhnd_port_cd] --[old_pol] --  [old_pod] :cod_port" ).append("\n"); 
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
		query.append("AND    D.LGS_COST_CD         IN ('SVRHCD','TPNDTS','SVLDTS','TMNDTS','TPNDFL','SVLDFL','TMNDFL')" ).append("\n"); 
		query.append("AND    NVL(D.THRP_COST_CD_FLG,'N') <> 'Y'" ).append("\n"); 
		query.append("AND    TO_NUMBER(NVL(D.FM_TR_VOL_VAL,'1')) = 1" ).append("\n"); 
		query.append("AND    NVL(D.LANE_CD,'N')    = DECODE(NVL(D.LANE_CD,'N'),'N','N','Sam','Sam','OTH','OTH',V.SLAN_CD)" ).append("\n"); 
		query.append("AND    NVL(D.IOC_CD,'N')     IN ('N','S','O')" ).append("\n"); 
		query.append("AND    NVL(D.IO_BND_CD,'N')  IN ('N','S','O')" ).append("\n"); 
		query.append("AND    NVL(D.TML_TRNS_MOD_CD,'N') = DECODE(NVL(D.TML_TRNS_MOD_CD,'N'),'N','N','S','S',D.TML_TRNS_MOD_CD)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_OFC_CTY_CD = C.TML_AGMT_OFC_CTY_CD(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_SEQ        = C.TML_AGMT_SEQ(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_VER_NO     = C.TML_AGMT_VER_NO(+)" ).append("\n"); 
		query.append("AND    D.TML_AGMT_DTL_SEQ    = C.TML_AGMT_DTL_SEQ(+)" ).append("\n"); 
		query.append("AND    DECODE(D.TML_AGMT_VOL_UT_CD,'C',C.CNTR_TPSZ_CD,'N') = DECODE(D.TML_AGMT_VOL_UT_CD,'C',V_TEMP1.TPSZ,'N')" ).append("\n"); 
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
		query.append("GROUP BY D.CURR_CD,V_TEMP1.TPSZ, V_TEMP1.QTY" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("V_TEMP3 AS(" ).append("\n"); 
		query.append("SELECT SUM(F.DVS_FEE_AMT) DVS_FEE_AMT_SUM" ).append("\n"); 
		query.append("FROM   BKG_COD C, MDM_LOCATION L, OPF_COD_DVS_FEE F, GL_MON_XCH_RT G, VSK_VSL_PORT_SKD V, VSK_VSL_PORT_SKD S, MDM_LOCATION M" ).append("\n"); 
		query.append(",V_TEMP2" ).append("\n"); 
		query.append("WHERE  C.BKG_NO            = @[bkg_no]       --:bkg_no" ).append("\n"); 
		query.append("AND    C.COD_RQST_SEQ      = @[cod_rqst_seq] --:req_seq" ).append("\n"); 
		query.append("AND    C.COD_RHND_PORT_CD  = L.LOC_CD" ).append("\n"); 
		query.append("AND    L.CONTI_CD          = F.CONTI_CD" ).append("\n"); 
		query.append("AND    F.DELT_FLG          = 'N'" ).append("\n"); 
		query.append("AND    C.OLD_VSL_CD        = V.VSL_CD" ).append("\n"); 
		query.append("AND    C.OLD_SKD_VOY_NO    = V.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    C.OLD_SKD_DIR_CD    = V.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    V.VPS_PORT_CD       = L.LOC_CD" ).append("\n"); 
		query.append("AND    V.VSL_CD            = S.VSL_CD" ).append("\n"); 
		query.append("AND    V.SKD_VOY_NO        = S.SKD_VOY_NO" ).append("\n"); 
		query.append("AND    V.SKD_DIR_CD        = S.SKD_DIR_CD" ).append("\n"); 
		query.append("AND    S.CLPT_SEQ          = S.CLPT_SEQ - 1" ).append("\n"); 
		query.append("AND    S.VPS_PORT_CD       = M.LOC_CD" ).append("\n"); 
		query.append("AND    F.DVS_FEE_TP_CD     = DECODE(SUBSTR(L.CNT_CD,1,2),'US','B',DECODE(L.SCONTI_CD,M.SCONTI_CD,'I',DECODE(SUBSTR(V_TEMP2.TPSZ,2,1),2,2,4)))" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_LVL   = 1" ).append("\n"); 
		query.append("AND    G.CURR_CD           = V_TEMP2.CURR_CD" ).append("\n"); 
		query.append("AND    G.ACCT_XCH_RT_YRMON = TO_CHAR(SYSDATE,'YYYYMM')" ).append("\n"); 
		query.append("AND    F.DVS_FEE_AMT       > (V_TEMP2.RATE/G.USD_LOCL_XCH_RT)" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT DECODE(NVL(V3.DVS_FEE_AMT_SUM,0),0, 'RLO', 'DVC')                     CHG," ).append("\n"); 
		query.append("DECODE(NVL(V3.DVS_FEE_AMT_SUM,0),0, V2.CURR_CD, 'USD')                CUR," ).append("\n"); 
		query.append("DECODE(NVL(V3.DVS_FEE_AMT_SUM,0),0, V2.RATE, V3.DVS_FEE_AMT_SUM)      RATE," ).append("\n"); 
		query.append("V2.TPSZ                                                               TPSZ," ).append("\n"); 
		query.append("V2.QTY                                                                QTY," ).append("\n"); 
		query.append("V2.QTY * V2.RATE                                                      AMT" ).append("\n"); 
		query.append("FROM V_TEMP3 V3, V_TEMP2 V2" ).append("\n"); 

	}
}